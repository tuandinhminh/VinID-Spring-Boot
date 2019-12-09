package com.example.demo.service;

import com.example.demo.dto.UsersDTO;
import com.example.demo.entity.UsersEntity;
import com.example.demo.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class UsersService implements UserDetailsService {
    @Autowired
    private IUsersRepository iUsersRepository;

    public List<UsersDTO> getUsers(){
        List<UsersEntity> entities = iUsersRepository.findAll();
        List<UsersDTO> dtos = new ArrayList<>();
        for(UsersEntity item: entities){
            UsersDTO dto = new UsersDTO(
                    item.getId(),
                    item.getCreatedDate(),
                    item.getModifiedDate(),
                    item.getUserName(),
                    item.getEmail(),
                    item.getPassword()
            );
            dtos.add(dto);
        }
        return  dtos;
    }
    public UsersDTO getUserById(long id) {
        UsersEntity entity = iUsersRepository.findOneById(id);
        UsersDTO dto = new UsersDTO(
                entity.getId(),
                entity.getCreatedDate(),
                entity.getModifiedDate(),
                entity.getUserName(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getRole()
        );
        return dto;
    }
    public List<UsersDTO> getUserByEmail(String email) {
        List<UsersEntity> entities = iUsersRepository.findAllByEmail(email,
                PageRequest.of(0,3, Sort.by("id").descending()));
        List<UsersDTO> dtos = new ArrayList<>();
        for (UsersEntity entity : entities) {
            UsersDTO dto = new UsersDTO(
                    entity.getId(),
                    entity.getCreatedDate(),
                    entity.getModifiedDate(),
                    entity.getUserName(),
                    entity.getEmail(),
                    entity.getPassword()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    public UsersDTO getOneByUserName(String userName){
        UsersEntity entity = iUsersRepository.findOneByUserName(userName);
        return new UsersDTO(entity.getId(),
                entity.getCreatedDate(),
                entity.getModifiedDate(),
                entity.getUserName(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getRole()
        );
    }

    public UsersDTO saveUser(UsersDTO model) {
        UsersEntity entity = new UsersEntity();
        if (model.getId() != null){
            entity = iUsersRepository.findOneById(model.getId());
        }
        entity.setUserName(model.getUsername());
        entity.setEmail(model.getEmail());
        entity.setPassword(model.getPassword());
        entity.setRole("USER");

        entity =iUsersRepository.save(entity);
        UsersDTO dto = new UsersDTO(
                entity.getId(),
                entity.getCreatedDate(),
                entity.getModifiedDate(),
                entity.getUserName(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getRole()
                );
        return dto;
    }


    public void deleteUsers(long[] ids) {
        for(long item: ids) {
            iUsersRepository.deleteById(item);
        }
    }
    @Transactional
    public ResponseEntity<?> testTransaction() throws Exception {
        List<UsersEntity> list = new ArrayList<>();

        list.add(new UsersEntity("Nguyễn Công Phương", "123123", "phuong1@gmail.com","user"));
        list.add(new UsersEntity("Nguyễn Quang Hải", "123123", "hai@gmail.com","user"));

        for (UsersEntity user : list) {
            UsersEntity newUser = iUsersRepository.save(user);
        }

//        int a = 10/0;

        return ResponseEntity.ok("Insert đủ rồi. Vào database kiểm tra đi");
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UsersEntity item = iUsersRepository.findOneByUserName(userName);
            if (item.getUserName().equals(userName)) {
                String password = new BCryptPasswordEncoder().encode(item.getPassword());
                return User.withUsername(item.getUserName()).password(password).
                        roles(item.getRole()).build();
            } else {
                throw new UsernameNotFoundException(userName);
            }
//        if ("whoami".equals(username)) {
//            String password = new BCryptPasswordEncoder().encode("123456");
//            return User.withUsername("whoami").password(password).roles("USER").build();
//        } else {
//            throw new UsernameNotFoundException(username);
//        }
    }
}

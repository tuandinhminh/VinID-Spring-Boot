package com.example.demo.service;

import com.example.demo.dto.UsersDTO;
import com.example.demo.entity.UsersEntity;
import com.example.demo.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
@Service
public class UsersService {
    @Autowired
    private IUsersRepository iUsersRepository;
    public ResponseEntity<?> getUsers(){
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
        return  ResponseEntity.ok(dtos);
    }
    public UsersDTO getUserById(long id) {
        UsersEntity entity = iUsersRepository.findOneById(id);
        UsersDTO dto = new UsersDTO(
                entity.getId(),
                entity.getCreatedDate(),
                entity.getModifiedDate(),
                entity.getUserName(),
                entity.getEmail(),
                entity.getPassword()
        );
        return dto;
    }
    public List<UsersDTO> getUserByEmail(String email) {
        List<UsersEntity> entities = iUsersRepository.findOneByEmail(email,
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
    public UsersDTO saveUser(UsersDTO model) {
        UsersEntity entity = new UsersEntity();;
        if (model.getId() != null){
            entity = iUsersRepository.findOneById(model.getId());
            entity.setUserName(model.getUsername());
            entity.setEmail(model.getEmail());
            entity.setPassword(model.getPassword());
        } else{
            entity.setUserName(model.getUsername());
            entity.setEmail(model.getEmail());
            entity.setPassword(model.getPassword());
        }
        entity =iUsersRepository.save(entity);
        UsersDTO dto = new UsersDTO(
                entity.getId(),
                entity.getCreatedDate(),
                entity.getModifiedDate(),
                entity.getUserName(),
                entity.getEmail(),
                entity.getPassword()
                );
        return dto;
    }


    public void deleteUsers(long[] ids) {
        for(long item: ids) {
            iUsersRepository.deleteById(item);
        }
    }
}

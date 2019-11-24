package com.example.demo.controller;
import com.example.demo.entity.UsersEntity;
import com.example.demo.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UsersController {
    @Autowired
    private IUsersRepository iUsersRepository;

    @GetMapping(value = "/users")
    public List<UsersEntity> getUsers(){
        List<UsersEntity> usersEntity = iUsersRepository.findAll();
        return  usersEntity;
    }

    @PostMapping(value = "/users")
    public UsersEntity createUser(@RequestBody UsersEntity model) {
        UsersEntity usersEntity = new UsersEntity();
        usersEntity = iUsersRepository.save(model);
        return usersEntity;
    }
    @PutMapping(value = "/users/{id}")
    public UsersEntity updateNew(@RequestBody UsersEntity model, @PathVariable("id") long id) {
        model.setId(id);
        return iUsersRepository.save(model);
    }
    @DeleteMapping(value = "/users")
    public void deleteUsers(@RequestBody long[] ids) {
        for(long item: ids) {
            iUsersRepository.deleteById(item);
        }
    }
}

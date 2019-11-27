package com.example.demo.controller;
import com.example.demo.dto.UsersDTO;
import com.example.demo.entity.UsersEntity;
import com.example.demo.service.UsersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;

    @ApiOperation(value = "Lấy danh sách user")
    @GetMapping(value = "/users")
    public ResponseEntity<?> getUsers(){
        return  usersService.getUsers();
    }

    @ApiOperation(value = "thêm mới user")
    @PostMapping(value = "/users")
    public UsersDTO createUser(@RequestBody UsersDTO model) {
        return usersService.saveUser(model);
    }

    @ApiOperation(value = "Sửa thông tin user")
    @PutMapping(value = "/users/{id}")
    public UsersDTO updateUser(@RequestBody UsersDTO model, @PathVariable("id") Long id) {
        model.setId(id);
        return usersService.saveUser(model);
    }

    @ApiOperation(value = "Lấy thông tin user theo id")
    @GetMapping(value = "/users/{id}")
    public UsersDTO getUserById(@PathVariable("id") long id) {
        return usersService.getUserById(id);
    }

    @ApiOperation(value = "Lấy thông tin user theo email")
    @GetMapping(value = "/user/{email}")
    public List<UsersDTO> getUserByEmail(@PathVariable("email") String email) {
        return usersService.getUserByEmail(email);
    }

    @ApiOperation(value = "Xóa user")
    @DeleteMapping(value = "/users")
    public void deleteUsers(@RequestBody long[] ids) {
        usersService.deleteUsers(ids);
    }
}

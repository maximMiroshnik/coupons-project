package com.maxim.coupons.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.maxim.coupons.dto.UserLoginData;
import com.maxim.coupons.dto.UsersDTO;
import com.maxim.coupons.entities.User;
import com.maxim.coupons.logic.UserLogic;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;

/**
 * @author Maxim Myroshnyk
 * @date 3/1/2023 11:00 AM
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private UserLogic userLogic;

    @Autowired
    public UserController(UserLogic userLogic) {
        this.userLogic = userLogic;
    }

    @PostMapping
    public void createUser(@RequestBody User user) throws ServerException {
        userLogic.createUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginData userLoginData) throws ServerException, JsonProcessingException {
        String token= userLogic.login(userLoginData);
        return token;
    }

    @PutMapping
    public void updateUser(@RequestBody User user) throws ServerException {
        userLogic.updateUser(user);
    }

    @GetMapping
    public List<UsersDTO> getAllUsers() {
        return userLogic.getAllUsers();
    }

    @GetMapping("{id}")
    public UsersDTO getUserById(@PathVariable long id) {
        return userLogic.getUserById(id);
    }

    @GetMapping("/name/{name}")
    public UsersDTO getUserByName(@PathVariable String name) {
        return userLogic.getUserByName(name);
    }

    @DeleteMapping
    public void deleteAllUsers() {
        userLogic.deleteAllUsers();
    }

    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable long id) {
        userLogic.deleteUserById(id);
    }
}

package com.chat.userservice.controllers;

import com.chat.userservice.Entity.User;
import com.chat.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users" )
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String addUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/")
    public List<User> getUsers(){
        return userService.findAll();
    }


    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable("userId") int userId){
        return userService.getUserById(userId);

 }

    @PutMapping("/user/{userId}")
    public User updateUserById(@RequestBody User user) {
        return userService.updateUser(user);

    }

    @DeleteMapping("/user/{userId}")
    public String deleteById(@PathVariable int id) {
        return userService.deleteUser(id);




    }
}

package com.ga.springbootspotify.controller;

import com.ga.springbootspotify.model.User;
import com.ga.springbootspotify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!!";
    }

    @GetMapping("/user/list")
    public Iterable<User> listUsers() {
        return userService.listUsers();
    }

    @PostMapping("/signup")
    public User createUser(@RequestBody User newUser){
        return userService.createUser(newUser);
    }

    @GetMapping("/login/{username}/{password}")
    public User login(@PathVariable String username, @PathVariable String password) {
        return userService.login(username, password);
    }

    @PutMapping("/user/{username}/{songId}")
    public User addSong(@PathVariable String username, @PathVariable Long songId){
        return userService.addSong(username, songId);
    }


}
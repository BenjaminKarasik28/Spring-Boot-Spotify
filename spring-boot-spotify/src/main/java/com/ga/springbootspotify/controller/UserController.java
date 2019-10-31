package com.ga.springbootspotify.controller;

import com.ga.springbootspotify.model.JwtResponse;
import com.ga.springbootspotify.model.User;
import com.ga.springbootspotify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        return ResponseEntity.ok(new JwtResponse(userService.createUser(newUser)));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        return ResponseEntity.ok(new JwtResponse(userService.login(user)));
    }

    @PutMapping("/user/{username}/{songId}")
    public User addSong(@PathVariable String username, @PathVariable Long songId){
        return userService.addSong(username, songId);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/user/{userId}")
    public HttpStatus deleteUserById(@PathVariable Long userId) {
        userService.deleteById(userId);
        return HttpStatus.OK;
    }




}
package com.ga.springbootspotify.service;

import com.ga.springbootspotify.model.User;

public interface UserService {

    public Iterable<User> listUsers();

    public User createUser(User newUser);

    public User login(String username, String password);

}
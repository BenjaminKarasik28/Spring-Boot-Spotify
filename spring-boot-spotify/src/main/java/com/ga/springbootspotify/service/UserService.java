package com.ga.springbootspotify.service;

import com.ga.springbootspotify.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public Iterable<User> listUsers();

    public String createUser(User user);

    public String login(User user);

    public User getUser(String username);

    public User addSong(String username, Long songId);

    public void deleteById(Long userId);

}
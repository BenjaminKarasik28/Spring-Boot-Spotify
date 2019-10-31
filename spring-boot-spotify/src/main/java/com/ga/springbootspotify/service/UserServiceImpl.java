package com.ga.springbootspotify.service;

import com.ga.springbootspotify.model.Song;
import com.ga.springbootspotify.model.User;
import com.ga.springbootspotify.repositories.SongRepository;
import com.ga.springbootspotify.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    SongRepository songRepository;

    @Override
    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public User login(String username, String password) {
        return userRepository.login(username, password);
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User addSong(String username, Long songId) {
        Song song  = songRepository.findById(songId).get();
        User user = getUser(username);
        user.addSong(song);

        return userRepository.save(user);

    }
    }

//        User user = getUser(username);
//        user.addCourse(course);
//
//        return userRepository.save(user);

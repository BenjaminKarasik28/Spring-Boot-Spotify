package com.ga.springbootspotify.service;

import com.ga.springbootspotify.config.JwtUtil;
import com.ga.springbootspotify.model.Song;
import com.ga.springbootspotify.model.User;
import com.ga.springbootspotify.model.UserRole;
import com.ga.springbootspotify.repositories.SongRepository;
import com.ga.springbootspotify.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    @InjectMocks
    UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    User user;

    @InjectMocks
    UserRole userRole;

    @Mock
    UserRoleService userRoleService;

    @Mock
    SongRepository songRepository;

    @Mock
    JwtUtil jwtUtil;

    @InjectMocks
    Song song;

    @InjectMocks
    List<User> userList;

    @Mock
    PasswordEncoder bCryptPasswordEncoder;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public void init() {
        user.setId(1L);
        user.setUsername("ben");
        userRole.setName("ROLE_ADMIN");
        user.setUserRole(userRole);

        userList.add(user);

        song.setId(2L);
        user.addSong(song);
    }

    @Test
    public void createUser_User_Success() {
        when(userRoleService.getRole(any())).thenReturn(userRole);
        when(bCryptPasswordEncoder.encode(any())).thenReturn("test");
        when(userRepository.findByUsername(any())).thenReturn(user);
        when(userRepository.save(any())).thenReturn(user);
        when(jwtUtil.generateToken(any())).thenReturn("23143");

        String test = userService.createUser(user);
        assertNotNull(test);
    }

    @Test
    public void login_User_Success() {
        when(userRepository.findByUsername(user.getUsername())).thenReturn(user);
        when(bCryptPasswordEncoder.matches(any(), any())).thenReturn(true);
        when(bCryptPasswordEncoder.encode(any())).thenReturn("test");
        when(jwtUtil.generateToken(any())).thenReturn("23143");

        String test = userService.login(user);

        assertNotNull(test);
    }

    @Test
    public void getUser_User_Success() {
        when(userRepository.findByUsername(any())).thenReturn(user);

        User test = userService.getUser(user.getUsername());
        assertNotNull(test);
        assertEquals(user, test);
    }


    @Test
    public void listUsers_User_Success() {

        when(userRepository.findAll()).thenReturn(userList);

        List<User> users = (ArrayList<User>) userService.listUsers();

        assertNotNull(users);
        assertEquals(userList, users);
    }

    @Test
    public void addSong_User_Success() {

        when(userService.getUser(anyString())).thenReturn(user);
        when(songRepository.findById(3L)).thenReturn(Optional.of(song));


        User test = userService.addSong(user.getUsername(), 2L);

        assertNotNull(test);
        assertEquals(test, user);
    }



}

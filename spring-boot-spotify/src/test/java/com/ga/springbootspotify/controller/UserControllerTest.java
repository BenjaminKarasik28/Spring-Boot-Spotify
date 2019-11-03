package com.ga.springbootspotify.controller;

import com.ga.springbootspotify.config.JwtUtil;
import com.ga.springbootspotify.service.UserService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.junit.runner.RunWith;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    /**Main entry point for server-side Spring MVC test support.**/
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private JwtUtil jwtUtil;


    @Test
    public void login_Returns200_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createUserInJson("batman","robin"));

        when(userService.login(any())).thenReturn("123456");
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"token\":\"123456\"}"))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void signup_Returns200_Success()throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createUserInJson("batman","robin", "ROLE_ADMIN"));

        when(userService.login(any())).thenReturn("123456");
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"token\":\"123456\"}"))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());

    }
    private static String createUserInJson (String name, String password) {
        return "{ \"name\": \"" + name + "\", " +
                "\"password\":\"" + password + "\"}";
    }

    private static String createUserInJson (String name, String password, String roleName) {
        return "{ \"username\": \"" + name + "\", " +
                "\"password\":\"" + password + "\", " +
                "\"userRole\": { \"name\": \"" + roleName +"\" }}";
    }


}
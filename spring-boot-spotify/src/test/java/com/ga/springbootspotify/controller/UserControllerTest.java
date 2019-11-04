package com.ga.springbootspotify.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ga.springbootspotify.config.JwtUtil;
import com.ga.springbootspotify.model.User;
import com.ga.springbootspotify.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    @Mock
    private List<User> userList;

    @InjectMocks
    private User user;

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

        when(userService.createUser(any())).thenReturn("123456");
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"token\":\"123456\"}"))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());

    }

    @Test
    @WithMockUser(username = "ben", password = "test")
    public void listUsers_UserController_Success() throws Exception {
        userList = new ArrayList<>();
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/list")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @WithMockUser(username = "ben", password = "test")
    public void addSong_Song_Success() throws Exception {


        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/user/"+ 1L +"/"+ 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "23421");

        when(userService.addSong(any(), any())).thenReturn(user);

        ObjectMapper mapper = new ObjectMapper();
        String userMapper = mapper.writeValueAsString(user);
        System.out.println(userMapper);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(userMapper))
                .andReturn();
    }

    @Test
    @WithMockUser(username = "ben", password = "test", roles = {"ROLE_ADMIN"})
    public void deleteUserById_UserController_Success() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/user/" + 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "76362");


        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
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
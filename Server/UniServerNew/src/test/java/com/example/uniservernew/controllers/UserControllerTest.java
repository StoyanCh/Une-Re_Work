package com.example.uniservernew.controllers;

import com.example.uniservernew.data.controllers.UserController;
import com.example.uniservernew.data.entities.Users;
import com.example.uniservernew.data.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = false)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @TestConfiguration
    static class TestConfig {
        @Bean
        public UserService userService() {
            return mock(UserService.class);
        }
    }

    @Test
    void testGetUserByEgn_ReturnsUser_WhenUserExists() throws Exception {
        Users mockUser = new Users();
        mockUser.setUserid(1);
        mockUser.setUserFirstName("Иван");
        mockUser.setUserLastName("Иванов");
        mockUser.setUserEgn("1234567890");

        when(userService.findByUserEgn("1234567890")).thenReturn(Optional.of(mockUser));

        mockMvc.perform(get("/api/users/byEgn/1234567890"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userFirstName").value("Иван"))
                .andExpect(jsonPath("$.userLastName").value("Иванов"));
    }

    @Test
    void testGetUserByEgn_Returns404_WhenUserNotFound() throws Exception {
        when(userService.findByUserEgn("0000000000")).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/users/byEgn/0000000000"))
                .andExpect(status().isNotFound());
    }
}
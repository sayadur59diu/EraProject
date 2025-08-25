package com.example.mockitoeg.controller;

import com.example.mockitoeg.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerPositiveTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test @DisplayName("GET valid ID returns user")
    void testGetUser_ReturnsUserName() throws Exception {
        when(userService.getUserName(1L)).thenReturn("User-1");
        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("User-1"));
        verify(userService, times(1)).getUserName(1L);
    }

    @Test @DisplayName("POST valid name returns created user")
    void testCreateUser_ReturnsCreatedUser() throws Exception {
        when(userService.createUser("John")).thenReturn("Created: John");
        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"John\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Created: John"));
    }

    @Test @DisplayName("GET another ID returns correct user")
    void testGetUser_DifferentId() throws Exception {
        when(userService.getUserName(5L)).thenReturn("User-5");
        mockMvc.perform(get("/api/users/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("User-5"));
    }

    @Test @DisplayName("POST name with spaces works")
    void testCreateUser_WithSpaces() throws Exception {
        when(userService.createUser("John Doe")).thenReturn("Created: John Doe");
        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"John Doe\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Created: John Doe"));
    }

    @Test @DisplayName("GET non-existent user returns empty string")
    void testGetUser_NotFoundScenario() throws Exception {
        when(userService.getUserName(99L)).thenReturn("");
        mockMvc.perform(get("/api/users/99"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test @DisplayName("POST empty name returns Created: ")
    void testCreateUser_EmptyName() throws Exception {
        when(userService.createUser("")).thenReturn("Created: ");
        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Created: "));
    }

    @Test @DisplayName("GET verify service call")
    void testGetUser_VerifyServiceCall() throws Exception {
        when(userService.getUserName(10L)).thenReturn("User-10");
        mockMvc.perform(get("/api/users/10"))
                .andExpect(status().isOk())
                .andExpect(content().string("User-10"));
        verify(userService, times(1)).getUserName(10L);
    }

    @Test @DisplayName("POST large name works")
    void testCreateUser_LargeName() throws Exception {
        String largeName = "A".repeat(100);
        when(userService.createUser(largeName)).thenReturn("Created: " + largeName);
        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"" + largeName + "\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Created: " + largeName));
    }

    @Test @DisplayName("GET negative ID works")
    void testGetUser_NegativeId() throws Exception {
        when(userService.getUserName(-1L)).thenReturn("User--1");
        mockMvc.perform(get("/api/users/-1"))
                .andExpect(status().isOk())
                .andExpect(content().string("User--1"));
    }

    @Test @DisplayName("POST null name works")
    void testCreateUser_NullName() throws Exception {
        when(userService.createUser(null)).thenReturn("Created: null");
        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": null}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Created: null"));
    }
}

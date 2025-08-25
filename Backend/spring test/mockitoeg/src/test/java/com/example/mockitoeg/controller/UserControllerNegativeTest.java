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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerNegativeTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    // ✅ Pass
    @Test @DisplayName("GET valid user works")
    void testGetUser_Valid() throws Exception {
        when(userService.getUserName(1L)).thenReturn("User-1");
        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("User-1"));
    }

    // ❌ Fail: Wrong expected string
    @Test @DisplayName("GET valid user wrong expectation")
    void testGetUser_WrongExpectation() throws Exception {
        when(userService.getUserName(2L)).thenReturn("User-2");
        mockMvc.perform(get("/api/users/2"))
                .andExpect(status().isOk())
                .andExpect(content().string("Wrong-User"));
    }

    // ❌ Fail: Wrong ID expected
    @Test @DisplayName("GET user mismatch in expectation")
    void testGetUser_Mismatch() throws Exception {
        when(userService.getUserName(5L)).thenReturn("User-5");
        mockMvc.perform(get("/api/users/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("User-6"));
    }

    // ✅ Pass
    @Test @DisplayName("POST works with correct input")
    void testCreateUser_Valid() throws Exception {
        when(userService.createUser("John")).thenReturn("Created: John");
        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"John\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Created: John"));
    }

    // ❌ Fail: Null name expectation mismatch
    @Test @DisplayName("POST null name fails expectation")
    void testCreateUser_NullNameFail() throws Exception {
        when(userService.createUser(null)).thenReturn("Created: null");
        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": null}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Wrong Output"));
    }
}

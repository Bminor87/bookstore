package com.hellmanstudios.bookstore.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;

@SpringBootTest
@AutoConfigureMockMvc
public class BookRestControllerTest {

    @Autowired
    private WebApplicationContext webAppContext;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
    }

    // Test the get all books endpoint
    @Test
    public void statusOk() throws Exception {
        mockMvc.perform(get("/api/books")).andExpect(status().isOk());
    }

    // Test the post book endpoint
    @WithMockUser(authorities = "ADMIN")
    @Test
    public void postBook() throws Exception {

        mockMvc.perform(post("/api/books")
            .contentType("application/json")
            .content("{\"title\":\"Test Title\",\"author\":\"Test Author\",\"isbn\":\"1234567890123\",\"publicationYear\":2021,\"price\":10.0,\"category\":{\"id\":1}}"))
            .andExpect(status().isCreated());
    }

    // Test the put book endpoint
    @WithMockUser(authorities = "ADMIN")
    @Test
    public void putBook() throws Exception {

        mockMvc.perform(put("/api/books/1")
            .contentType("application/json")
            .content("{\"title\":\"Test Title\",\"author\":\"Test Author\",\"isbn\":\"1234567890123\",\"publicationYear\":2021,\"price\":10.0,\"category\":{\"id\":1}}"))
            .andExpect(status().isOk());
    }

    // Test the delete book endpoint
    @WithMockUser(authorities = "ADMIN")
    @Test
    public void deleteBook() throws Exception {
        mockMvc.perform(delete("/api/books/1")).andExpect(status().isOk());
    }

    // Test POST validation
    @WithMockUser(authorities = "ADMIN")
    @Test
    public void postValidation() throws Exception {

        // ISBN too short
        mockMvc.perform(post("/api/books")
            .contentType("application/json")
            .content("{\"title\":\"Test Title\",\"author\":\"Test Author\",\"isbn\":\"123\",\"publicationYear\":2021,\"price\":10.0}"))
            .andExpect(status().isBadRequest());

        // Title empty
        mockMvc.perform(post("/api/books")
            .contentType("application/json")
            .content("{\"title\":\"\",\"author\":\"Test Author\",\"isbn\":\"1234567890\",\"publicationYear\":2021,\"price\":10.0}"))
            .andExpect(status().isBadRequest());
    }

}


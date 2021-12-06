package com.manifestcorp.techreads;

import com.manifestcorp.techreads.controller.BookController;
import com.manifestcorp.techreads.controller.IndexController;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(IndexController.class)
public class BookControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void homePageTest() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isFound())
                .andExpect(content().string(""));
    }


    @Test
    public void addedBookTest() throws Exception{
        mockMvc.perform(post("/"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("books"));
    }
}

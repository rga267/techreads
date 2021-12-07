package com.manifestcorp.techreads;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manifestcorp.techreads.controller.RestController;
import com.manifestcorp.techreads.model.Book;
import com.manifestcorp.techreads.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RestController.class)
public class RestControllerTests {

    List books = new ArrayList<Book>();
    Book bookToTest;

    @BeforeEach
    void setUp(){
        for(int i=0; i<5; i++){
            books.add(i,new Book( "url", "title", "author", 2));
        }

        bookToTest = new Book("urltest", "titletest", "authortest", 2);

    }

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BookRepository bookRepository;

    @Test
    public void getBookTest() throws Exception{
        when(bookRepository.findAll()).thenReturn(books);

        mockMvc.perform(get("/dev/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title", is("title")))
                .andExpect(jsonPath("$[0].author", is("author")))
                .andExpect(jsonPath("$[0].rating", is(2)));

        verify(bookRepository).findAll();

    }


    @Test
    public void addedBookTest() throws Exception{
        mockMvc.perform(post("/dev/books"))
                .andExpect(status().isCreated());
    }

}

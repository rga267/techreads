package com.manifestcorp.techreads;

import com.manifestcorp.techreads.model.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BookTests {

    private Book bookToTest;

    @BeforeEach
    public void before() throws Exception{
        bookToTest = new Book("https://google.com", "Groovy", "Chris", 5);

    }

    @AfterEach
    public void after() throws Exception{
        bookToTest = null;
    }

    @Test
    public void isCorrectAuthor(){
        assertEquals("Chris", bookToTest.getAuthor());
    }

    @Test
    public void isCorrectTitle(){
        assertEquals("Groovy", bookToTest.getTitle());
    }

    @Test
    public void isCorrectRating(){
        assertEquals(5 , bookToTest.getRating());
    }

    @Test
    public void isCorrectUrl(){
        assertEquals("https://google.com", bookToTest.getUrl());
    }


}

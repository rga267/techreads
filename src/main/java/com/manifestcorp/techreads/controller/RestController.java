package com.manifestcorp.techreads.controller;

import com.manifestcorp.techreads.model.Book;
import com.manifestcorp.techreads.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/dev/books")
public class RestController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<List<Book>> findAll(){
        List<Book> books = bookRepository.findAll();
        return ResponseEntity.ok().body(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findBook(@PathVariable("id") Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return ResponseEntity.of(book);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book new_book = new Book(book);
        bookRepository.saveAndFlush(new_book);
        return new ResponseEntity<>(new_book, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> editBook(@PathVariable("id") Long id, @RequestBody Book book) {
        Optional<Book> old_book = bookRepository.findById(id);
        if(old_book.isPresent()){
            Book bookv2 = old_book.get();
            bookv2.setUrl(book.getUrl());
            bookv2.setAuthor(book.getAuthor());
            bookv2.setTitle(book.getTitle());
            bookv2.setId(book.getId());
            bookv2.setRating(book.getRating());
            return new ResponseEntity<>(bookv2, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") long id){
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}


package com.manifestcorp.techreads.controller;

import com.manifestcorp.techreads.model.Book;
import com.manifestcorp.techreads.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping({"","/"})
    public ModelAndView books(){
        ModelAndView mav = new ModelAndView("books");
        List<Book> books = bookRepository.findAll();
        mav.addObject("books", books);
        return mav;

    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("bookForm", new Book());
        return "add";
    }

    @RequestMapping(value={"","/"}, method=POST)
    public RedirectView addBook(Book book){
        bookRepository.saveAndFlush(book);
        return new RedirectView("books");
    }

    @RequestMapping("/delete/{bookId}")
    public RedirectView deleteBook(@PathVariable("bookId") Long bookId){
        bookRepository.deleteById(bookId);
        return new RedirectView("http://localhost:8080/books");

    }

    @RequestMapping("/details/{bookId}")
    public ModelAndView details(@PathVariable("bookId") Long bookId){
        ModelAndView mav = new ModelAndView("details");
        Book book = bookRepository.getById(bookId);
        mav.addObject("book", book);
        return mav;

    }

    @RequestMapping("/edit/{bookId}")
    public String edit(Model model, @PathVariable("bookId") Long bookId){
        Book book = bookRepository.getById(bookId);
        model.addAttribute("bookForm", book);
        return "edit";
    }

    @RequestMapping(value={"","/"}, method=PUT)
    public RedirectView editBook(Book book){
        bookRepository.saveAndFlush(book);
        return new RedirectView("books");
    }

}


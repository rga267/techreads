package com.manifestcorp.techreads.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String url;
    String title;
    String author;
    Integer rating;

    public Book(){}

    public Book(String url, String title, String author, Integer rating){
        this.url = url;
        this.title = title;
        this.author = author;
        this.rating = rating;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url){this.url = url;}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getRating() {
        return rating;
    }

    public String getUrl() {
        return url;
    }

}

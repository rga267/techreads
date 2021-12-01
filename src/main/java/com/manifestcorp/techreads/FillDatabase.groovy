package com.manifestcorp.techreads
import groovy.sql.Sql
import groovy.json.JsonSlurper

def sql = Sql.newInstance("jdbc:mysql://localhost/techreads", "techreads", "techreads")

sql.execute("delete from book")

def json = new JsonSlurper()

def api_endpoint = new URL("https://www.googleapis.com/books/v1/volumes?q=pokemon")

def response = json.parse(api_endpoint)

def books = sql.dataSet("book")
    for (int i = 0; i < 20; i++) {
        def bookInfo = response.items[i].volumeInfo;
        books.add(id: i, url: bookInfo.imageLinks.thumbnail, title: bookInfo.title, author: bookInfo.authors.join(", "), rating: bookInfo.averageRating)
    }

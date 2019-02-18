package com.bookstore.bookstore_springboot.wrapper;

import com.bookstore.bookstore_springboot.entity.Book;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = BookSerialize.class)
@JsonDeserialize(using = BookDeserialize.class)
public class BookWrapper {

    private Book book;

    public BookWrapper(final Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
}
package com.bookstore.bookstore_springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookId;
    private String bookTitle;
    private String bookDescription;
    private long isbn;
    private String language;

    protected Book(){}

    //TODO: Teste sem isbn
    public Book(String bookTitle, String bookDescription, String language) {
        this.bookTitle = bookTitle;
        this.bookDescription = bookDescription;
        this.language = language;
    }

    public Book(String bookTitle, String bookDescription, long isbn, String language) {
        this.bookTitle = bookTitle;
        this.bookDescription = bookDescription;
        this.isbn = isbn;
        this.language = language;
    }

    public long getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getLanguage() {
        return language;
    }
}

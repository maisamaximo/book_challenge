package com.bookstore.bookstore_springboot.service;

import com.bookstore.bookstore_springboot.entity.Book;
import com.bookstore.bookstore_springboot.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService
{
    public BookRepository bookRepository;

    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public Book findBookById(long bookId)
    {
        return bookRepository.findById(bookId)
                .orElseThrow(NoSuchElementException::new);
    }

    public void saveBook(Book book)
    {
        bookRepository.save(book);
    }

    public List<Book> findAll()
    {
        return bookRepository.findAll();
    }
}

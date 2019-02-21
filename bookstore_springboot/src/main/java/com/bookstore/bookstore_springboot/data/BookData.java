package com.bookstore.bookstore_springboot.data;

import com.bookstore.bookstore_springboot.entity.Book;
import com.bookstore.bookstore_springboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.List;

public class BookData implements CommandLineRunner
{
    private BookRepository bookRepository;

    @Autowired
    private BookData(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }
    @Override
    public void run(String... args) throws Exception
    {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Effective Java",
                              "Java has changed dramatically since the previous edition of Effective Java was published shortly after the release of Java 6.",
                              9780134686097l,
                              "en"));
        bookList.add(new Book("Clean Code",
                              "Even bad code can function. But if code isn’t clean, it can bring a development organization to its knees. Every year, countless hours and significant resources are lost because of poorly written code. But it doesn’t have to be that way.",
                              123456789,
                              "en"));
        bookList.add(new Book("he Pragmatic Programmer",
                              "What others in the trenches say about The Pragmatic Programmer... “The cool thing about this book is that it’s great for keeping the programming process fresh. ",
                              147852369,
                              "en"));

        bookRepository.saveAll(bookList);
    }
}

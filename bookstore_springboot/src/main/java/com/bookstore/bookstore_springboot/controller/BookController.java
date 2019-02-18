package com.bookstore.bookstore_springboot.controller;

import com.bookstore.bookstore_springboot.entity.Book;
import com.bookstore.bookstore_springboot.service.BookService;
import com.bookstore.bookstore_springboot.service.SearchBookResponseService;
import com.bookstore.bookstore_springboot.wrapper.BookWrapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/")
public class BookController
{
    public BookService bookService;
    public SearchBookResponseService searchBookResponseService;

    @Autowired
    public BookController(BookService bookService, SearchBookResponseService searchBookResponseService) {
        this.bookService = bookService;
        this.searchBookResponseService = searchBookResponseService;
    }
    //TODO: Criar novo livro
    @PostMapping("/book")
    public ResponseEntity<?> createNewBook(@RequestBody BookWrapper bookWrapper){
        bookService.saveBook(bookWrapper.getBook());
        return new ResponseEntity<>(bookService.findAll(),HttpStatus.CREATED);
    }

    //TODO: Todos os livros cadastrados
    @GetMapping("/allBooks")
    public ResponseEntity<?> getAllBooks(){
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    //TODO: Exibir dados de determinado livro através do id
    @GetMapping(value = "/books/{bookId}")
    public ResponseEntity<?> findBookById(@PathVariable long bookId)
    {
        try
        {
            bookService.findBookById(bookId);
            final BookWrapper bookWrapper = new BookWrapper(bookService.findBookById(bookId));
            return new ResponseEntity<>(bookWrapper, HttpStatus.OK);

        }catch (NoSuchElementException e)
        {
            return new ResponseEntity<>("Unexpected Id: no data found!",HttpStatus.NOT_FOUND);
        }
    }

    //TODO: Buscar dados de um site e exibir como json (faltando isbn e id)
    @GetMapping("books")
    public ResponseEntity<?> searchBooks() throws IOException {
        Document document = Jsoup.connect("https://kotlinlang.org/docs/books.html").timeout(6000).get();

        final List<Book> books = searchBookResponseService.splitSections(document);
        final SearchBookResponseService responseService = new SearchBookResponseService(books);

        return new ResponseEntity<>(responseService, HttpStatus.OK);
    }


}

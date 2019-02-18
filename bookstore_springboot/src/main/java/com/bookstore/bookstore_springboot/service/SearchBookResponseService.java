package com.bookstore.bookstore_springboot.service;

import com.bookstore.bookstore_springboot.entity.Book;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchBookResponseService
{
    private long bookId;
    private int numberOfBooks;
    private List<Book> books;

    protected SearchBookResponseService(){}

    public SearchBookResponseService(List<Book> books) {
        this.books = books;
        this.numberOfBooks = books.size();
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book){
        books.add(book);
    }

    /**
     *
     * @param pDocument url the web address of the site
     * @return
     */
    public List<Book> splitSections(Document pDocument)
    {
        List<Book> books = new ArrayList<>();
        Element source = pDocument.getElementsByTag("article").first();
        while (source.getElementsByTag("h2").size() > 0)
        {
            Element title = source.getElementsByTag("h2").first();
            Element desc = source.getElementsByTag("p").first();
            Element lang = source.getElementsByClass("book-lang").first();
//            Element isbn = source.getElementsByTag("a").first();

            Book book = new Book(title.text(), lang.text(), desc.text());
            books.add(book);

            title.remove();
            desc.remove();
            lang.remove();
//            isbn.remove();
        }
        return books;
    }
}

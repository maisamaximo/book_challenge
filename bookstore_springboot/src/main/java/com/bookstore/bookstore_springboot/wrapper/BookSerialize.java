package com.bookstore.bookstore_springboot.wrapper;

import com.bookstore.bookstore_springboot.entity.Book;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class BookSerialize extends JsonSerializer<BookWrapper>
{
    @Override
    public void serialize(BookWrapper bookWrapper, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Book book = bookWrapper.getBook();

        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", book.getBookId());
        jsonGenerator.writeStringField("title", book.getBookTitle());
        jsonGenerator.writeStringField("description", book.getBookDescription());
        jsonGenerator.writeNumberField("isbn", book.getIsbn());
        jsonGenerator.writeStringField("language", book.getLanguage());
        jsonGenerator.writeEndObject();
    }
}

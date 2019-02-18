package com.bookstore.bookstore_springboot.wrapper;

import com.bookstore.bookstore_springboot.entity.Book;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class BookDeserialize extends JsonDeserializer<BookWrapper>
{
    @Override
    public BookWrapper deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = jsonParser.getCodec();
        JsonNode jsonNode = objectCodec.readTree(jsonParser);

        final String title = jsonNode.get("title").asText();
        final String description = jsonNode.get("description").asText();
        final long isbn = jsonNode.get("isbn").asLong();
        final String language = jsonNode.get("language").asText();

        return new BookWrapper(new Book(title, description, isbn, language));
    }
}

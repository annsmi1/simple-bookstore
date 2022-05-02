package pl.annsmi.bookstore.model.dto;

import pl.annsmi.bookstore.model.Author;
import pl.annsmi.bookstore.model.Book;

import java.util.Set;
import java.util.stream.Collectors;

public class ReadAuthorDTO {
    private String name;
    private String surname;
    private Set<String> books;

    public ReadAuthorDTO(Author source){
        name = source.getName();
        surname = source.getSurname();
        books = source.getBooks()
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toSet());
    }
}

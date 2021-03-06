package pl.annsmi.bookstore.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.annsmi.bookstore.model.Author;
import pl.annsmi.bookstore.model.Book;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReadAuthorDTO {
    private String name;
    private String surname;
    private Set<String> books;

    public ReadAuthorDTO(Author source){
        name = source.getName();
        surname = source.getSurname();
        books = Optional.ofNullable(source.getBooks()).orElseGet(Collections::emptySet)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toSet());
    }
}

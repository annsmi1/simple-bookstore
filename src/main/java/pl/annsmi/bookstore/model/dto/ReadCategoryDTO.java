package pl.annsmi.bookstore.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.annsmi.bookstore.model.Author;
import pl.annsmi.bookstore.model.Book;
import pl.annsmi.bookstore.model.Category;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReadCategoryDTO {
    private String name;
    private Set<String> books;

    public ReadCategoryDTO(Category source){
        name = source.getName();
        books = Optional.ofNullable(source.getBooks()).orElseGet(Collections::emptySet)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toSet());
    }
}

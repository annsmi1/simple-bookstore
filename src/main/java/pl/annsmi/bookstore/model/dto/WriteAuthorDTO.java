package pl.annsmi.bookstore.model.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import pl.annsmi.bookstore.model.Author;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class WriteAuthorDTO {
//    private int id;
    private String name;
    private String surname;
//    private Set<WriteBookDTO> books;

//    public Author toAuthor(){
//        var result = new Author();
//        result.setId(id);
//        result.setName(name);
//        result.setSurname(surname);
////        result.setBooks(books.stream()
////                .map(WriteBookDTO::toBook)
////                .collect(Collectors.toSet()));
//        return result;
//    }
}

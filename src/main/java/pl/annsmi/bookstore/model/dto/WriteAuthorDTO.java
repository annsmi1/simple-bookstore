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

    private String name;
    private String surname;


    public Author toAuthor(){
        var result = new Author();
        result.setName(name);
        result.setSurname(surname);
        return result;
    }
}

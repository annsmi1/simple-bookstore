package pl.annsmi.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table()

public class Book {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "A book must have a title!")
    private String title;
    private String description;
    @NotBlank(message = "Book must have an author!")
    private int authorId;
    @NotBlank()
    private boolean checkedOut;
    @NotBlank
    private String category;

}

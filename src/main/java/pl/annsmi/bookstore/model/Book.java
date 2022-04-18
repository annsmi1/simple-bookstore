package pl.annsmi.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "books")

public class Book {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "A book must have a title!")
    private String title;
    @NotNull
    @Column(name="author_id")
    private int authorId;
    @NotNull()
    private boolean purchased;
    @NotNull()
    @Column(name="catgory_id")
    private int categoryId;
    private String description;

}

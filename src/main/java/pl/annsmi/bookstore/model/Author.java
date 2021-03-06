package pl.annsmi.bookstore.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="authors")

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private Set<Book> books;
}

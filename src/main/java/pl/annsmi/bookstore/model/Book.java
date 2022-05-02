package pl.annsmi.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "books")


public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "A book must have a title!")
    private String title;
    @NotNull
    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;
    @NotNull()
    private boolean purchased;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String description;
    private float price;

    public Book(String title, Author author, Category category, String description, float price){
        this.title = title;
        this.author = author;
        this.category= category;
        this.description = description;
        this.price = price;
    }


}

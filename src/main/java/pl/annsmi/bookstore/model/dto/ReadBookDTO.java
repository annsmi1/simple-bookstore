package pl.annsmi.bookstore.model.dto;

import lombok.Getter;
import lombok.Setter;
import pl.annsmi.bookstore.model.Book;

@Getter
@Setter
public class ReadBookDTO {

    private String title;
    private String authorName;
    private String category;
    private String description;
    private float price;

    public ReadBookDTO(Book source){
        this.title = source.getTitle();
        this.authorName = source.getAuthor().getName() + ' ' +  source.getAuthor().getSurname();
        this.category = source.getCategory().getName();
        this.description = source.getDescription();
        this.price = source.getPrice();
    }

}

package pl.annsmi.bookstore.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WriteBookDTO {
    private String title;
    private int authorId;
    private int categoryId;
    private String description;
    private float price;

}

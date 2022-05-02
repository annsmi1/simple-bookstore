package pl.annsmi.bookstore.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import pl.annsmi.bookstore.model.Author;
import pl.annsmi.bookstore.model.Book;
import pl.annsmi.bookstore.model.Category;
import pl.annsmi.bookstore.model.dto.ReadBookDTO;
import pl.annsmi.bookstore.model.dto.WriteBookDTO;
import pl.annsmi.bookstore.repository.AuthorRepository;
import pl.annsmi.bookstore.repository.BookRepository;
import pl.annsmi.bookstore.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
public class BookService {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private CategoryRepository categoryRepository;

     BookService(final BookRepository bookRepository, final AuthorRepository authorRepository, final CategoryRepository categoryRepository) {
         this.bookRepository = bookRepository;
         this.authorRepository = authorRepository;
         this.categoryRepository = categoryRepository;
     }

     public ReadBookDTO addBook(WriteBookDTO source){
         Book result = bookRepository.save(writeBookDTOToBook(source));
         return new ReadBookDTO(result);
     }

     public List<ReadBookDTO> readAll(){
         return bookRepository.findAll().stream().map(ReadBookDTO::new).collect(Collectors.toList());
     }

     public ReadBookDTO updateBook(int id, WriteBookDTO model) throws IllegalArgumentException{
         Book source = writeBookDTOToBook(model);
         Book toUpdate = bookRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Given book doesnt exist!"));
         toUpdate.setCategory(source.getCategory());
         toUpdate.setPrice(source.getPrice());
         toUpdate.setTitle(source.getTitle());
         toUpdate.setAuthor(source.getAuthor());
         toUpdate.setDescription(source.getDescription());
         bookRepository.save(toUpdate);
         return new ReadBookDTO(toUpdate);
     }


     public Book writeBookDTOToBook(WriteBookDTO model) throws IllegalStateException{
         var result = new Book();
         Author author = authorRepository.findById(model.getAuthorId()).orElseThrow(()-> new IllegalStateException("The author with given id doesnt exist!"));
         result.setAuthor(author);
         result.setTitle(model.getTitle());
         result.setDescription(model.getDescription());
         result.setPrice(model.getPrice());
         Category category = categoryRepository.findById(model.getCategoryId()).orElseThrow(()-> new IllegalStateException("The category with given id doesnt exist!"));
         result.setCategory(category);
         return result;
     }
}

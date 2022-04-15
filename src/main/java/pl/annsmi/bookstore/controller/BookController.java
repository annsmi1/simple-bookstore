package pl.annsmi.bookstore.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.annsmi.bookstore.model.Book;
import pl.annsmi.bookstore.repository.BookRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {
    private final BookRepository repository;

    BookController(final BookRepository repository){
        this.repository = repository;
    }



    @GetMapping("/books")
    ResponseEntity<List<Book>> readAllBooks(Pageable page){
        return ResponseEntity.ok(repository.findAll(page).getContent());
    }

    @PutMapping("/books/{id}")
    ResponseEntity<?> updateBook(@PathVariable int id, @RequestBody @Valid Book toUpdate){
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/books")
    ResponseEntity<?> addBook(@RequestBody @Valid Book toAdd){
        repository.save(toAdd);
        return ResponseEntity.noContent().build();
    }
}

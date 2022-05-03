package pl.annsmi.bookstore.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.annsmi.bookstore.model.dto.ReadBookDTO;
import pl.annsmi.bookstore.model.dto.WriteBookDTO;
import pl.annsmi.bookstore.service.BookService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {

    private final BookService service;

    BookController(final BookService service) {
        this.service = service;
    }

    @GetMapping("/books")
    ResponseEntity<List<ReadBookDTO>> readAllBooks(){
        return ResponseEntity.ok(service.readAll());
    }

    @GetMapping("/books/{id}")
    ResponseEntity<ReadBookDTO> readSingleBook(@RequestParam int id){
        try{
            return ResponseEntity.ok(service.readSingleBook(id));
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/books/{id}")
    ResponseEntity<?> updateBook(@PathVariable int id, @RequestBody @Valid WriteBookDTO source){
        try{
            service.updateBook(id,source);
            return ResponseEntity.noContent().build();
        }
        catch (IllegalArgumentException | IllegalStateException exception){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/books")
    ResponseEntity<?> addBook(@RequestBody @Valid WriteBookDTO toAdd){
        try{
        service.addBook(toAdd);
        return ResponseEntity.noContent().build();
        }
        catch(IllegalStateException exception){
            return ResponseEntity.badRequest().build();
        }
    }
}


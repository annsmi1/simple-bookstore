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
//    ResponseEntity<List<ReadBookDTO>> readAllBooks(){
//        return ResponseEntity.ok(service.readAll());
//    }

    public List<ReadBookDTO> readAllBooks(){
        return service.readAll();
    }

    @PutMapping("/books/{id}")
    ResponseEntity<?> updateBook(@PathVariable int id, @RequestBody @Valid WriteBookDTO source){
        try{
            service.updateBook(id,source);
            return ResponseEntity.noContent().build();
        }
        catch (IllegalArgumentException exception){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/books")
    ResponseEntity<?> addBook(@RequestBody @Valid WriteBookDTO toAdd){
        service.addBook(toAdd);
        return ResponseEntity.noContent().build();
    }
}


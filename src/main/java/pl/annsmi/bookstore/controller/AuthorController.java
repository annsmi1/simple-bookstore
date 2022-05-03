package pl.annsmi.bookstore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.annsmi.bookstore.model.dto.ReadAuthorDTO;
import pl.annsmi.bookstore.model.dto.ReadBookDTO;
import pl.annsmi.bookstore.model.dto.WriteAuthorDTO;
import pl.annsmi.bookstore.service.AuthorService;

import javax.validation.Valid;
import java.util.List;


@Controller
public class AuthorController {
    private final AuthorService service;

    AuthorController(final AuthorService service) {
        this.service = service;
    }

    @GetMapping("/authors")
    ResponseEntity<List<ReadAuthorDTO>> readAuthors(){
        return ResponseEntity.ok(service.readAllAuthors());
    }

    @PostMapping("/authors")
    ResponseEntity<?> addAuthor(@RequestBody @Valid WriteAuthorDTO toAdd){
        service.addAuthor(toAdd);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/authors/{id}")
    ResponseEntity<?> updateAuthor(@RequestParam int id, @RequestBody @Valid WriteAuthorDTO source){
        try{
            service.updateAuthor(id,source);
            return ResponseEntity.noContent().build();
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().build();
        }
    }
}

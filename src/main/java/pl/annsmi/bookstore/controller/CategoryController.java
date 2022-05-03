package pl.annsmi.bookstore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.annsmi.bookstore.model.Category;
import pl.annsmi.bookstore.model.dto.ReadCategoryDTO;
import pl.annsmi.bookstore.repository.CategoryRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CategoryController {

    private final CategoryRepository repository;
     CategoryController(final CategoryRepository repository){
         this.repository = repository;
     }

     @GetMapping("/categories")
    ResponseEntity<List<ReadCategoryDTO>> readAllCategories(){
         return ResponseEntity.ok(repository.findAll().stream().map(ReadCategoryDTO::new).collect(Collectors.toList()));
     }

     @PostMapping("/categories")
    ResponseEntity<Category> addCategory(@RequestBody @Valid Category category){
         repository.save(category);
         return ResponseEntity.ok(category);
     }
}

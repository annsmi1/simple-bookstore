package pl.annsmi.bookstore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.annsmi.bookstore.model.Author;


import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findAll();
    Page<Author> findAll(Pageable page);
    Optional<Author> findById(Integer id);
    boolean existsById(Integer id);
    Author save(Author entity);
    Author findAuthorByNameAndAndSurname(String name, String surname);
}

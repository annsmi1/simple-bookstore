package pl.annsmi.bookstore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.annsmi.bookstore.model.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAll();
    Page<Book> findAll(Pageable page);
    Optional<Book> findById(Integer id);
    boolean existsById(Integer id);
    Book save(Book entity);

}

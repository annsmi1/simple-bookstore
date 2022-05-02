package pl.annsmi.bookstore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.annsmi.bookstore.model.Category;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAll();
    Page<Category> findAll(Pageable page);
    Optional<Category> findById(Integer id);
    boolean existsById(Integer id);
    Category save(Category entity);
}

package org.example.demo.repository;
import org.example.demo.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Integer> {
    List<CategoryModel> findByNameContainingIgnoreCase(String name);
}
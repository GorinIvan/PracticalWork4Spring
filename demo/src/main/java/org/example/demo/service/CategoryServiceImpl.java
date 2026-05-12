package org.example.demo.service;
import org.example.demo.model.CategoryModel;
import org.example.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;
    public CategoryServiceImpl(CategoryRepository repository) { this.repository = repository; }

    @Override public List<CategoryModel> findAllCategories() { return repository.findAll(); }
    @Override public CategoryModel saveCategory(CategoryModel category) { return repository.save(category); }
    @Override public CategoryModel findById(int id) { return repository.findById(id).orElse(null); }
    @Override public List<CategoryModel> searchByName(String name) { return repository.findByNameContainingIgnoreCase(name); }
    @Override public CategoryModel updateCategory(CategoryModel category) { return repository.save(category); }
    @Override public void deleteCategory(int id) { repository.deleteById(id); }
}
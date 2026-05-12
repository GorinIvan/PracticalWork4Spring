package org.example.demo.service;
import org.example.demo.model.CategoryModel;
import java.util.List;

public interface CategoryService {
    List<CategoryModel> findAllCategories();
    CategoryModel saveCategory(CategoryModel category);
    CategoryModel findById(int id);
    List<CategoryModel> searchByName(String name);
    CategoryModel updateCategory(CategoryModel category);
    void deleteCategory(int id);
}
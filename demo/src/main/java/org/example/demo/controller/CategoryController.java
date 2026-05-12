package org.example.demo.controller;
import org.example.demo.model.CategoryModel;
import org.example.demo.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService service;
    public CategoryController(CategoryService service) { this.service = service; }

    @GetMapping
    public String listCategories(Model model, @RequestParam(required = false) Integer searchId, @RequestParam(required = false) String searchName) {
        if (searchId != null) {
            CategoryModel c = service.findById(searchId);
            model.addAttribute("categories", c != null ? java.util.List.of(c) : java.util.List.of());
        } else if (searchName != null && !searchName.isEmpty()) {
            model.addAttribute("categories", service.searchByName(searchName));
        } else {
            model.addAttribute("categories", service.findAllCategories());
        }
        return "categoryList";
    }

    @PostMapping
    public String saveCategory(CategoryModel category) {
        service.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        service.deleteCategory(id);
        return "redirect:/categories";
    }
}
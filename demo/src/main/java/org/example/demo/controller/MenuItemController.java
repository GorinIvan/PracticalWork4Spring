package org.example.demo.controller;

import org.example.demo.model.MenuItemModel;
import org.example.demo.service.MenuItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menuItems")
public class MenuItemController {

    private final MenuItemService service;

    public MenuItemController(MenuItemService service) {
        this.service = service;
    }

    @GetMapping
    public String listMenuItems(Model model,
                                @RequestParam(required = false) Integer searchId,
                                @RequestParam(required = false) String searchName) {
        // Логика поиска
        if (searchId != null) {
            MenuItemModel item = service.findById(searchId);
            model.addAttribute("menuItems", item != null ? java.util.List.of(item) : java.util.List.of());
        } else if (searchName != null && !searchName.isEmpty()) {
            model.addAttribute("menuItems", service.searchByName(searchName));
        } else {
            model.addAttribute("menuItems", service.findAllMenuItems());
        }
        return "menuItemList";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("menuItem", new MenuItemModel());
        return "menuItemForm";
    }

    @PostMapping
    public String saveMenuItem(@ModelAttribute("menuItem") MenuItemModel menuItem) {
        service.saveMenuItem(menuItem);
        return "redirect:/menuItems";
    }

    @GetMapping("/delete/{id}")
    public String deleteMenuItem(@PathVariable("id") int id) {
        service.deleteMenuItem(id);
        return "redirect:/menuItems";
    }
}
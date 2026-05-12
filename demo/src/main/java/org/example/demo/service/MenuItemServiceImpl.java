package org.example.demo.service;

import org.example.demo.model.MenuItemModel;
import org.example.demo.repository.MenuItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository repository;

    public MenuItemServiceImpl(MenuItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MenuItemModel> findAllMenuItems() {
        return repository.findAll();
    }

    @Override
    public MenuItemModel saveMenuItem(MenuItemModel menuItem) {
        return repository.save(menuItem);
    }

    @Override
    public MenuItemModel findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<MenuItemModel> searchByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public MenuItemModel updateMenuItem(MenuItemModel menuItem) {
        return repository.save(menuItem);
    }

    @Override
    public void deleteMenuItem(int id) {
        repository.deleteById(id);
    }
}
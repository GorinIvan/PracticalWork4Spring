package org.example.demo.service;

import org.example.demo.model.MenuItemModel;
import java.util.List;

public interface MenuItemService {
    List<MenuItemModel> findAllMenuItems();
    MenuItemModel saveMenuItem(MenuItemModel menuItem);
    MenuItemModel findById(int id);
    List<MenuItemModel> searchByName(String name);
    MenuItemModel updateMenuItem(MenuItemModel menuItem);
    void deleteMenuItem(int id);
}
package org.example.demo.repository;

import org.example.demo.model.MenuItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItemModel, Integer> {
    List<MenuItemModel> findByNameContainingIgnoreCase(String name);
}
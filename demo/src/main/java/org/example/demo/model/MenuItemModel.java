package org.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "menu_item")
public class MenuItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMenuItem;

    private String name;
    private String description;
    private double price;
    private boolean isAvailable;
    private String imageUrl;
    private int categoryId;

    // ОБЯЗАТЕЛЬНО: пустой конструктор для базы данных
    public MenuItemModel() {}

    public MenuItemModel(int idMenuItem, String name, String description, double price, boolean isAvailable, String imageUrl, int categoryId) {
        this.idMenuItem = idMenuItem;
        this.name = name;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
    }

    // Геттеры и сеттеры (остаются как у тебя)
    public int getIdMenuItem() { return idMenuItem; }
    public void setIdMenuItem(int idMenuItem) { this.idMenuItem = idMenuItem; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }
}
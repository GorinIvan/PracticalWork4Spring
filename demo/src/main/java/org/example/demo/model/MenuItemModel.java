package org.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "menu_item")
public class MenuItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMenuItem;

    @NotBlank(message = "Название обязательно")
    @Size(min = 2, max = 100, message = "Название должно быть от 2 до 100 символов")
    private String name;
    @NotBlank(message = "Описание обязательно")
    @Size(min = 5, max = 255, message = "Описание должно быть от 5 до 255 символов")
    private String description;
    @DecimalMin(value = "0.01", message = "Цена должна быть больше 0")
    private double price;
    private boolean isAvailable;
    @NotBlank(message = "Ссылка на изображение обязательна")
    @Size(max = 255, message = "Ссылка слишком длинная")
    private String imageUrl;
    @Positive(message = "ID категории должен быть больше 0")
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

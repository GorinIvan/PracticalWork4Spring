package org.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "roles")
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;
    @NotBlank(message = "Название роли обязательно")
    @Size(min = 2, max = 50, message = "Название роли должно быть от 2 до 50 символов")
    private String nameRole;
    @NotBlank(message = "Описание обязательно")
    @Size(min = 5, max = 255, message = "Описание должно быть от 5 до 255 символов")
    private String description;

    public RoleModel() {}

    public int getIdRole() { return idRole; }
    public void setIdRole(int idRole) { this.idRole = idRole; }
    public String getNameRole() { return nameRole; }
    public void setNameRole(String nameRole) { this.nameRole = nameRole; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}

package org.example.demo.model;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;
    private String nameRole;
    private String description;

    public RoleModel() {}

    public int getIdRole() { return idRole; }
    public void setIdRole(int idRole) { this.idRole = idRole; }
    public String getNameRole() { return nameRole; }
    public void setNameRole(String nameRole) { this.nameRole = nameRole; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
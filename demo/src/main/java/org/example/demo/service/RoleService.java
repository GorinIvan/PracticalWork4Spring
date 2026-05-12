package org.example.demo.service;
import org.example.demo.model.RoleModel;
import java.util.List;

public interface RoleService {
    List<RoleModel> findAllRoles();
    RoleModel saveRole(RoleModel role);
    RoleModel findById(int id);
    List<RoleModel> searchByName(String name);
    void deleteRole(int id);
}
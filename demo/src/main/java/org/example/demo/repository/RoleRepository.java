package org.example.demo.repository;
import org.example.demo.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Integer> {
    List<RoleModel> findByNameRoleContainingIgnoreCase(String nameRole);
}
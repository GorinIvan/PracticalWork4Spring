package org.example.demo.service;
import org.example.demo.model.RoleModel;
import org.example.demo.repository.RoleRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;
    public RoleServiceImpl(RoleRepository repository) { this.repository = repository; }

    @Override public List<RoleModel> findAllRoles() { return repository.findAll(); }
    @Override public RoleModel saveRole(RoleModel role) { return repository.save(role); }
    @Override public RoleModel findById(int id) { return repository.findById(id).orElse(null); }
    @Override public List<RoleModel> searchByName(String name) { return repository.findByNameRoleContainingIgnoreCase(name); }
    @Override public void deleteRole(int id) { repository.deleteById(id); }
}
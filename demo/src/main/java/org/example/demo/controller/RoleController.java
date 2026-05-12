package org.example.demo.controller;
import org.example.demo.model.RoleModel;
import org.example.demo.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class RoleController {
    private final RoleService service;
    public RoleController(RoleService service) { this.service = service; }

    @GetMapping
    public String listRoles(Model model, @RequestParam(required = false) Integer searchId, @RequestParam(required = false) String searchName) {
        if (searchId != null) {
            RoleModel r = service.findById(searchId);
            model.addAttribute("roles", r != null ? java.util.List.of(r) : java.util.List.of());
        } else if (searchName != null && !searchName.isEmpty()) {
            model.addAttribute("roles", service.searchByName(searchName));
        } else {
            model.addAttribute("roles", service.findAllRoles());
        }
        return "roleList";
    }

    @PostMapping
    public String saveRole(RoleModel role) { service.saveRole(role); return "redirect:/roles"; }

    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable int id) { service.deleteRole(id); return "redirect:/roles"; }
}
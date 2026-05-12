package org.example.demo.controller;

import jakarta.validation.Valid;
import org.example.demo.model.RoleModel;
import org.example.demo.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/roles")
public class RoleController {
    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @GetMapping
    public String listRoles(Model model,
                            @RequestParam(required = false) Integer searchId,
                            @RequestParam(required = false) String searchName) {
        if (searchId != null) {
            RoleModel r = service.findById(searchId);
            model.addAttribute("roles", r != null ? java.util.List.of(r) : java.util.List.of());
        } else if (searchName != null && !searchName.isEmpty()) {
            model.addAttribute("roles", service.searchByName(searchName));
        } else {
            model.addAttribute("roles", service.findAllRoles());
        }

        if (!model.containsAttribute("role")) {
            model.addAttribute("role", new RoleModel());
        }

        return "roleList";
    }

    @PostMapping
    public String saveRole(@Valid @ModelAttribute("role") RoleModel role,
                           BindingResult bindingResult,
                           Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("roles", service.findAllRoles());
            return "roleList";
        }

        service.saveRole(role);
        return "redirect:/roles";
    }

    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable int id) {
        service.deleteRole(id);
        return "redirect:/roles";
    }
}

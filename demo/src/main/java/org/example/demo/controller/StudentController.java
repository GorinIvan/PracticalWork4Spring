package org.example.demo.controller;
import org.example.demo.model.StudentModel;
import org.example.demo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service) { this.service = service; }

    @GetMapping
    public String listStudents(Model model, @RequestParam(required = false) Long searchId, @RequestParam(required = false) String searchName) {
        if (searchId != null) {
            StudentModel s = service.findById(searchId);
            model.addAttribute("students", s != null ? java.util.List.of(s) : java.util.List.of());
        } else if (searchName != null && !searchName.isEmpty()) {
            model.addAttribute("students", service.searchByName(searchName));
        } else {
            model.addAttribute("students", service.findAllStudent());
        }
        return "studentList";
    }

    @PostMapping
    public String saveStudent(StudentModel student) { service.createStudent(student); return "redirect:/students"; }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) { service.deleteStudent(id); return "redirect:/students"; }
}
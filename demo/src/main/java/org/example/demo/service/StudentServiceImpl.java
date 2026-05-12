package org.example.demo.service;
import org.example.demo.model.StudentModel;
import org.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    public StudentServiceImpl(StudentRepository repository) { this.repository = repository; }

    @Override public List<StudentModel> findAllStudent() { return repository.findAll(); }
    @Override public StudentModel createStudent(StudentModel student) { return repository.save(student); }
    @Override public StudentModel findById(Long id) { return repository.findById(id).orElse(null); }
    @Override public List<StudentModel> searchByName(String name) { return repository.findByNameContainingIgnoreCase(name); }
    @Override public void deleteStudent(Long id) { repository.deleteById(id); }
}
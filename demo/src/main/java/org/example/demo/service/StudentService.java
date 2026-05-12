package org.example.demo.service;
import org.example.demo.model.StudentModel;
import java.util.List;

public interface StudentService {
    List<StudentModel> findAllStudent();
    StudentModel createStudent(StudentModel student);
    StudentModel findById(Long id);
    List<StudentModel> searchByName(String name);
    void deleteStudent(Long id);
}
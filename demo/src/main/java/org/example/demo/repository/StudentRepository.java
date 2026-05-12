package org.example.demo.repository;
import org.example.demo.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {
    List<StudentModel> findByNameContainingIgnoreCase(String name);
}
package com.example.schoolmanager.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.schoolmanager.model.Student;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
}
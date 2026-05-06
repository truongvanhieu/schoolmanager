package com.example.studentmanager.controller;

import com.example.studentmanager.model.Student;
import com.example.studentmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentApiController {

    @Autowired
    private StudentRepository repo;

    @GetMapping
    public List<Student> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Student add(@RequestBody Student s) {
        return repo.save(s);
    }

    // 2: Xóa
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        repo.deleteById(id);
        return "Deleted!";
    }

    // 3: Search
    @GetMapping("/search")
    public List<Student> search(@RequestParam String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    // 4: Get by ID
    @GetMapping("/{id}")
    public Student getById(@PathVariable Integer id) {
        Optional<Student> s = repo.findById(id);
        return s.orElse(null);
    }

    // 6: Update
    @PostMapping("/update/{id}")
    public Student update(@PathVariable Integer id, @RequestBody Student newS) {
        return repo.findById(id).map(s -> {
            s.setName(newS.getName());
            s.setEmail(newS.getEmail());
            s.setAge(newS.getAge());
            return repo.save(s);
        }).orElse(null);
    }
}
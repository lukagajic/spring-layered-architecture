package com.lukagajic.demoapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.lukagajic.demoapp.domain.Student;
import com.lukagajic.demoapp.service.StudentService;
import com.lukagajic.demoapp.validator.EmailValidator;
import com.lukagajic.demoapp.validator.NameValidator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Optional<Student> student = studentService.getById(id);

        if (!student.isPresent()) {
            return new ResponseEntity<String>("No student found!", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Student student) {
        Map<String, String> errors = new HashMap<>();

        if (!new NameValidator().isValid(student.getForename())) {
            errors.put("forename", "Forename must contain at least 8 characters");
        }

        if (!new NameValidator().isValid(student.getSurname())) {
            errors.put("surname", "Surname must contain at least 8 characters");
        }

        if (!new EmailValidator().isValid(student.getEmail())) {
            errors.put("email", "Email is not in the right format");
        }

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        Student s = studentService.add(student);

        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }
}

package com.lukagajic.demoapp.service;

import java.util.List;
import java.util.Optional;

import com.lukagajic.demoapp.domain.Student;

public interface StudentService {
    List<Student> getAll();
    Optional<Student> getById(Integer id);
    Student add(Student student);
}

package com.lukagajic.demoapp.repository;

import java.util.List;
import java.util.Optional;

import com.lukagajic.demoapp.domain.Student;

public interface StudentRepository {
    List<Student> getAll();
    Optional<Student> getById(Integer id);
    Student add(Student student);
}

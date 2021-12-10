package com.lukagajic.demoapp.service.impl;

import java.util.List;
import java.util.Optional;

import com.lukagajic.demoapp.domain.Student;
import com.lukagajic.demoapp.repository.StudentRepository;
import com.lukagajic.demoapp.service.StudentService;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public Optional<Student> getById(Integer id) {
        return studentRepository.getById(id);
    }
    
    @Override
    public Student add(Student student) {
        student.setId(getAll().size() + 1);
        return studentRepository.add(student);
    }
}

package com.lukagajic.demoapp.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.lukagajic.demoapp.domain.Student;
import com.lukagajic.demoapp.repository.StudentRepository;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private List<Student> students;

    public StudentRepositoryImpl() {
        students = new ArrayList<>();
        
        students.add(new Student(1, "Pera", "Peric", "pperic@mail.local"));
        students.add(new Student(2, "Zika", "Zikic", "zzikic@mail.local"));
        students.add(new Student(3, "Laza", "Lazic", "llazic@mail.local"));
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public Optional<Student> getById(Integer id) {
        return students.stream().filter(s -> s.getId() == id).findFirst();
    }

    @Override
    public Student add(Student student) {
        students.add(student);
        return student;
    }
    
}

package com.example.springfirst.services;

import com.example.springfirst.entities.Student;
import com.example.springfirst.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student register(String name) {
        Student student = new Student(name);

        return studentRepository.save(student);
    }

    @Override
    public Student searchByName(String name) {
        return studentRepository.findByName(name);
    }
}

package com.example.springfirst.services;

import com.example.springfirst.entities.Student;

public interface StudentService {
    Student register(String name);

    Student searchByName(String name);
}

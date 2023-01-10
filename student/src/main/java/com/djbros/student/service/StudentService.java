package com.djbros.student.service;

import com.djbros.student.controller.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public Student getStudent(Long id) {
        Optional<Student> studentOptional = studentRepository.getStudent(id);
        return studentOptional.orElse(null);
    }
}

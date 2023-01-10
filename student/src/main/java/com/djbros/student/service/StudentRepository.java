package com.djbros.student.service;

import com.djbros.student.controller.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {
    private List<Student> allStudents = List.of(
            new Student(1L, "AJ", 22),
            new Student(2L, "AJ", 22),
            new Student(3L, "AJ", 22)
    );

    public List<Student> getAllStudents() {
        return allStudents;
    }

    public Optional<Student> getStudent(Long id) {
        return allStudents.stream().filter(student -> student.getId() == id).findFirst();
    }
}

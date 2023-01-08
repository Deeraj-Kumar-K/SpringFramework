package com.djbros.student.service;

import com.djbros.student.controller.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
@Component
public class StudentService {
    public List<Student> getStudent() {
        return List.of(new Student(1L, "AJ", 22),
                new Student(2L, "CJ", 25)
        );
    }
}

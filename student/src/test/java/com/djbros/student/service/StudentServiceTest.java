package com.djbros.student.service;

import com.djbros.student.controller.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;
    StudentService studentService = new StudentService(studentRepository);

    @BeforeEach
    void setUp() {
        studentService = new StudentService(studentRepository);
    }

    @Test
    void getAllStudents() {
        studentService.getAllStudents();
        verify(studentRepository).getAllStudents();
    }

    @Test
    void getStudentWithIdThatHasValue() {
        Optional<Student> studentOptional = Optional.of(new Student(1L, "Sonu", 23));
        when(studentRepository.getStudent(1L)).thenReturn(studentOptional);
        Student student = studentService.getStudent(1L);
        assertThat(student).isNotNull();
    }

    @Test
    void getStudentWithIdThatIsNull() {
        when(studentRepository.getStudent(anyLong())).thenReturn(Optional.empty());
        Student student = studentService.getStudent(1L);
        assertThat(student).isNull();
    }

    @Test
    void getStudentWithId() {
        Optional<Student> studentOptional = Optional.of(new Student(1L, "Sonu", 23));
        when(studentRepository.getStudent(1L)).thenReturn(studentOptional);
        Student student = studentService.getStudent(1L);
        assertThat(student.getName()).isEqualTo("Sonu");
    }

    @Test
    @DisplayName("Check id of returned student")
    public void getStudentWithId_fail() {
        Optional<Student> studentOptional = Optional.of(new Student(1L, "DJ", 23));
        when(studentRepository.getStudent(1L)).thenReturn(studentOptional);
        Student student = studentService.getStudent(1L);
        assertEquals(studentOptional.get().getId(), student.getId(), "Student id match");
    }

}
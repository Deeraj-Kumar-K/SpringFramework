package com.djbros.student.service;

import com.djbros.student.controller.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;
    @InjectMocks
    @Spy
    private StudentService studentService;

    @BeforeEach
    void setUp() {
//        studentService = new StudentService(studentRepository);
    }

    @Test
    @DisplayName("Get All Students")
    void getAllStudents() {
        List<Student> allStudents = List.of(
                new Student(1L, "AJ", 21),
                new Student(2L, "CJ", 22),
                new Student(3L, "DJ", 23)
        );
        when(studentRepository.getAllStudents()).thenReturn(allStudents);
        List<Student> result = studentService.getAllStudents();
        verify(studentRepository).getAllStudents();
        assertThat(result).isInstanceOf(List.class).isNotEmpty();
    }

    @Test
    @DisplayName("Get Student With Id That Has Value")
    void getStudentWithIdThatHasValue() {
        Optional<Student> studentOptional = Optional.of(new Student(1L, "Sonu", 23));
        when(studentRepository.getStudent(1L)).thenReturn(studentOptional);
        Student student = studentService.getStudent(1L);
        assertThat(student).isNotNull();
        verify(studentRepository).getStudent(any(Long.class));
        assertThat(student.getAge()).isEqualTo(23);
        assertThat(student.getId()).isEqualTo(1L);
        assertThat(student.getName()).isEqualTo("Sonu");
    }

    @Test
    @DisplayName("Get Student With Id That Is Null")
    void getStudentWithIdThatIsNull() {
        when(studentRepository.getStudent(anyLong())).thenReturn(Optional.empty());
        Student student = studentService.getStudent(1L);
        verify(studentRepository).getStudent(anyLong());
        assertThat(student).isNull();
    }

    @Test
    @DisplayName("Get Student With Id")
    void getStudentWithId() {
        Optional<Student> studentOptional = Optional.of(new Student(1L, "Sonu", 23));
        when(studentRepository.getStudent(1L)).thenReturn(studentOptional);
        Student student = studentService.getStudent(1L);
        assertThat(student).isNotNull();
        verify(studentRepository).getStudent(anyLong());
        assertThat(student.getName()).isEqualTo("Sonu");
        assertThat(student.getId()).isEqualTo(1L);
        assertThat(student.getAge()).isEqualTo(23);
    }

    @Test
    @DisplayName("Get Student With Id_Fail")
    public void getStudentWithId_fail() {
        Optional<Student> studentOptional = Optional.of(new Student(1L, "DJ", 23));
        Optional<Student> studentOptionalTwo = Optional.of(new Student(2L, "DJ", 23));
        when(studentRepository.getStudent(1L)).thenReturn(studentOptionalTwo);
        Student student = studentService.getStudent(1L);
        verify(studentRepository).getStudent(anyLong());
        assertNotEquals(studentOptional.get().getId(), student.getId(), "Student Id did not match");
    }

}
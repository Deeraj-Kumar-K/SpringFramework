package kumar.deeraj.springboot.learnjpahibernate.course.springdatajpa;

import kumar.deeraj.springboot.learnjpahibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByName(String name);

    List<Course> findByAuthor(String author);
}

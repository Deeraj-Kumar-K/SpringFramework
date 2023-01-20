package kumar.deeraj.springboot.learnjpahibernate.course;

import kumar.deeraj.springboot.learnjpahibernate.course.springdatajpa.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {
        courseRepository.save(new Course(1L, "Java", "Oracle"));
        courseRepository.save(new Course(2L, "Web Search", "Google"));
        courseRepository.save(new Course(3L, "Social Media", "Google"));

        courseRepository.deleteById(1L);

        System.out.println(courseRepository.findById(2L));
        System.out.println(courseRepository.findById(3L));

        System.out.println(courseRepository.findAll());

        System.out.println(courseRepository.findByName("Web Search"));
        System.out.println(courseRepository.findByAuthor("Google"));
    }
}

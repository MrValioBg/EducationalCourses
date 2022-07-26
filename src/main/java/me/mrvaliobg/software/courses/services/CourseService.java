package me.mrvaliobg.software.courses.services;

import lombok.RequiredArgsConstructor;
import me.mrvaliobg.software.courses.exceptions.NoCourseException;
import me.mrvaliobg.software.courses.models.Course;
import me.mrvaliobg.software.courses.models.Professor;
import me.mrvaliobg.software.courses.models.enums.Field;
import me.mrvaliobg.software.courses.models.enums.Status;
import me.mrvaliobg.software.courses.repository.CourseRepository;
import me.mrvaliobg.software.courses.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseService {

    private final CourseRepository repository;
    private final ProfessorRepository professorRepository;

    public void updateCourse(final long id, final Course courseRequest) {
        final Course course = getCourseById(id);

        course.setTitle(courseRequest.getTitle());
        course.setDescription(courseRequest.getDescription());
        course.setStatus(courseRequest.getStatus());

        course.setField(courseRequest.getField());
        course.setProfessor(courseRequest.getProfessor());
        repository.save(course);
    }

    public void updateCourse(final long id, final Status status) {
        final Course course = getCourseById(id);
        course.setStatus(status);
        repository.save(course);
    }

    public void updateCourse(final long id, final long professorId) {
        final Course course = getCourseById(id);

        repository.save(course);
    }

    public Course getCourseById(final long id) {
        return repository.findById(id).orElseThrow(NoCourseException::new);
    }

    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    public void deleteCourse(final long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        } else throw new NoCourseException();
    }

    public void addTask(Course course) {
        repository.save(course);
    }
}

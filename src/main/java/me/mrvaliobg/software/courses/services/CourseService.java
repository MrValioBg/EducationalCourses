package me.mrvaliobg.software.courses.services;

import lombok.AllArgsConstructor;
import me.mrvaliobg.software.courses.dto.CourseDTO;
import me.mrvaliobg.software.courses.dto.DTOConverter;
import me.mrvaliobg.software.courses.exceptions.NoCourseException;
import me.mrvaliobg.software.courses.models.Course;
import me.mrvaliobg.software.courses.models.enums.Status;
import me.mrvaliobg.software.courses.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CourseService {

    private final CourseRepository repository;
    private final ProfessorService professorService;
    private final DTOConverter dtoConverter;

    public void addCourse(CourseDTO course) {
        repository.save(dtoConverter.convertDtoToEntity(course));
    }

    public CourseDTO getCourseDTOById(final long id) {
        return dtoConverter.convertEntityToDTO(repository.findById(id).orElseThrow(NoCourseException::new));
    }

    public List<CourseDTO> getAllCourses() {
        return repository.findAll().stream().map(dtoConverter::convertEntityToDTO).collect(Collectors.toList());
    }

    private Course getCourseById(final long id) {
        return repository.findById(id).orElseThrow(NoCourseException::new);
    }

    public void updateProfessor(final long id, final CourseDTO courseRequest) {
        final Course course = getCourseById(id);

        course.setTitle(courseRequest.getTitle());
        course.setDescription(courseRequest.getDescription());
        course.setStatus(courseRequest.getStatus());
        course.setField(courseRequest.getField());

        repository.save(course);
    }

    public void updateStatus(final long id, final Status status) {
        final Course course = getCourseById(id);
        course.setStatus(status);
        repository.save(course);
    }

    public void updateProfessor(final long id, final long professorId) {
        final Course course = getCourseById(id);
        course.setProfessor(professorService.getProfessorById(professorId));
        repository.save(course);
    }

    public void deleteCourse(final long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else throw new NoCourseException();
    }

}

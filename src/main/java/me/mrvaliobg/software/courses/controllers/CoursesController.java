package me.mrvaliobg.software.courses.controllers;

import lombok.RequiredArgsConstructor;
import me.mrvaliobg.software.courses.dto.CourseDTO;
import me.mrvaliobg.software.courses.models.enums.Status;
import me.mrvaliobg.software.courses.services.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/courses")
public class CoursesController {

    private final CourseService service;

    @PostMapping("/")
    public void addCourse(@RequestBody final CourseDTO course) {
        service.addCourse(course);
    }

    @GetMapping("/")
    @CrossOrigin
    public List<CourseDTO> getAllCourses() {
        return service.getAllCourses();
    }

    @GetMapping(path = "{id}")
    @CrossOrigin
    public CourseDTO getCourseById(@PathVariable final long id) {
        return service.getCourseDTOById(id);
    }

    @PutMapping(path = "{id}")
    public void editCourse(@PathVariable final long id, @RequestBody final CourseDTO course) {
        service.updateProfessor(id, course);
    }

    @PutMapping(path = "{id}/status/{status}")
    public void updateStatus(@PathVariable final long id, @PathVariable final Status status) {
        service.updateStatus(id, status);
    }

    @PutMapping(path = "{id}/professor/{professor_id}")
    public void updateProfessor(@PathVariable final long id, @PathVariable final long professor_id) {
        service.updateProfessor(id, professor_id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCourseById(@PathVariable final long id) {
        service.deleteCourse(id);
    }
}

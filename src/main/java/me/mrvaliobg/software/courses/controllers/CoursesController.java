package me.mrvaliobg.software.courses.controllers;

import lombok.RequiredArgsConstructor;
import me.mrvaliobg.software.courses.dto.CourseDTO;
import me.mrvaliobg.software.courses.models.Course;
import me.mrvaliobg.software.courses.models.enums.Status;
import me.mrvaliobg.software.courses.services.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/courses")
public class CoursesController {

    private final CourseService service;

    @GetMapping("/")
    @CrossOrigin(origins = "localhost:8080")
    public List<Course> getAllCourses() {
        return service.getAllCourses();
    }

    @GetMapping(path = "{id}")
    @CrossOrigin
    public Course getCourseById(@PathVariable final long id) {
        return service.getCourseById(id);
    }

    @PostMapping("/")
    public void addCourse(@RequestBody final CourseDTO course) {
        service.addCourse(course);
    }

    @PutMapping(path = "{id}")
    public void editCourse(@PathVariable final long id, @RequestBody final CourseDTO course) {
        service.updateCourse(id, course);
    }

    @PutMapping(path = "{id}/status/{status}")
    public void updateStatus(@PathVariable final long id, @PathVariable final Status status) {
        service.updateCourse(id, status);
    }

    @PutMapping(path = "{id}/professor/{professor_id}")
    public void updateProfessor(@PathVariable final long id, @PathVariable final long professor_id) {
        service.updateCourse(id, professor_id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCourseById(@PathVariable final long id) {
        service.deleteCourse(id);
    }
}

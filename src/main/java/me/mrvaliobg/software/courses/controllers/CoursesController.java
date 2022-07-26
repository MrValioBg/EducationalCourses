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

    private final CourseService courseService;

    @GetMapping("/")
    @CrossOrigin(origins = "localhost:8080")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping(path = "{id}")
    @CrossOrigin
    public Course getCourseById(@PathVariable final long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping("/")
    public void addCourse(@RequestBody final CourseDTO course) {
        courseService.addCourse(course);
    }

    @PutMapping(path = "{id}")
    public void updateCourse(@PathVariable final long id, @RequestBody final CourseDTO course) {
        courseService.updateCourse(id, course);
    }

    @PutMapping(path = "{id}/{status}")
    public void updateCourse(@PathVariable final long id, @PathVariable final Status status) {
        courseService.updateCourse(id, status);
    }

    @PutMapping(path = "{id}/{professor_id}")
    public void updateCourse(@PathVariable final long id, @PathVariable final long professor_id) {
        courseService.updateCourse(id, professor_id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTaskById(@PathVariable final long id) {
        courseService.deleteCourse(id);
    }
}

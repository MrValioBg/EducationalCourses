package me.mrvaliobg.software.courses.controllers;

import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Adds a new Course entity.")
    @PostMapping("/")
    public void addCourse(@RequestBody final CourseDTO course) {
        service.addCourse(course);
    }

    @ApiOperation(value = "Gets a list of all the Courses in the database.")
    @GetMapping("/")
    public List<CourseDTO> getAllCourses() {
        return service.getAllCourses();
    }

    @ApiOperation(value = "Gets specific Course by id.")
    @GetMapping(path = "{id}")
    public CourseDTO getCourseById(@PathVariable final long id) {
        return service.getCourseDTOById(id);
    }


    @ApiOperation(value = "Updates the selected Course.")
    @PutMapping(path = "{id}")
    public void updateCourse(@PathVariable final long id, @RequestBody final CourseDTO course) {
        service.updateCourse(id, course);
    }

    @ApiOperation(value = "Updates the Course's status.")
    @PutMapping(path = "{id}/status/{status}")
    public void updateStatus(@PathVariable final long id, @PathVariable final Status status) {
        service.updateStatus(id, status);
    }

    @ApiOperation(value = "Assign or update the Professor for the Course.")
    @PutMapping(path = "{id}/professor/{professor_id}")
    public void updateProfessor(@PathVariable final long id, @PathVariable final long professor_id) {
        service.updateProfessor(id, professor_id);
    }

    @ApiOperation(value = "Deletes specific Course by its id.")
    @DeleteMapping(path = "{id}")
    public void deleteCourseById(@PathVariable final long id) {
        service.deleteCourse(id);
    }
}

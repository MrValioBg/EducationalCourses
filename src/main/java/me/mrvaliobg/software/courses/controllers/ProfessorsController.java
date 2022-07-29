package me.mrvaliobg.software.courses.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import me.mrvaliobg.software.courses.dto.CourseDTO;
import me.mrvaliobg.software.courses.dto.ProfessorDTO;
import me.mrvaliobg.software.courses.services.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/professors")
public class ProfessorsController {

    private final ProfessorService service;

    @ApiOperation(value = "Gets a list of all the Professors in the database.", tags = "getAllProfessors")
    @GetMapping(path = "/")
    @CrossOrigin
    public List<ProfessorDTO> getAllProfessors() {
        return service.getAllProfessors();
    }


    @ApiOperation(value = "Adds a new Professor entity.", tags = "addProfessor")
    @PostMapping("/")
    public void addProfessor(@RequestBody final ProfessorDTO professorDTO) {
        service.addProfessor(professorDTO);
    }

    @ApiOperation(value = "Updates the selected professor.", tags = "updateProfessor")
    @PutMapping(path = "{id}")
    public void updateProfessor(@PathVariable final long id, @RequestBody final ProfessorDTO professorDTO) {
        service.updateProfessor(id, professorDTO);
    }

    @ApiOperation(value = "Gets specific Professor by id.", response = CourseDTO.class, tags = "deleteCourseById")
    @GetMapping(path = "{id}")
    @CrossOrigin
    public ProfessorDTO getProfessorById(@PathVariable final long id) {
        return service.getProfessorDTOById(id);
    }

    @ApiOperation(value = "Gets all of the courses the Professor is assigned to.", response = CourseDTO.class, tags = "deleteCourseById")
    @GetMapping(path="{id}/courses")
    @CrossOrigin
    public Set<CourseDTO> getCourses(@PathVariable final long id) {
        return service.getCourses(id);
    }

    @ApiOperation(value = "Deletes specific Course by its id.", tags = "deleteCourseById")
    @DeleteMapping(path = "{id}")
    public void deleteCourseById(@PathVariable final long id) {
        service.deleteProfessor(id);
    }
}

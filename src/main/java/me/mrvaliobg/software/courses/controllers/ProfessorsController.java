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

    @ApiOperation(value = "Gets a list of all the Professors in the database.")
    @GetMapping(path = "/")
    public List<ProfessorDTO> getAllProfessors() {
        return service.getAllProfessors();
    }


    @ApiOperation(value = "Adds a new Professor entity.")
    @PostMapping("/")
    public void addProfessor(@RequestBody final ProfessorDTO professorDTO) {
        service.addProfessor(professorDTO);
    }

    @ApiOperation(value = "Updates the selected professor.")
    @PutMapping(path = "{id}")
    public void updateProfessor(@PathVariable final long id, @RequestBody final ProfessorDTO professorDTO) {
        service.updateProfessor(id, professorDTO);
    }

    @ApiOperation(value = "Gets specific Professor by id.", response = CourseDTO.class)
    @GetMapping(path = "{id}")
    public ProfessorDTO getProfessorById(@PathVariable final long id) {
        return service.getProfessorDTOById(id);
    }

    @ApiOperation(value = "Gets all of the courses the Professor is assigned to.")
    @GetMapping(path="{id}/courses")
    public Set<CourseDTO> getCourses(@PathVariable final long id) {
        return service.getCourses(id);
    }

    @ApiOperation(value = "Deletes specific Course by its id.")
    @DeleteMapping(path = "{id}")
    public void deleteProfessorById(@PathVariable final long id) {
        service.deleteProfessor(id);
    }
}

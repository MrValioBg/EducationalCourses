package me.mrvaliobg.software.courses.controllers;

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

    @GetMapping(path = "/")
    @CrossOrigin
    public List<ProfessorDTO> getAllProfessors() {
        return service.getAllProfessors();
    }

    @PostMapping("/")
    public void addProfessor(@RequestBody final ProfessorDTO professorDTO) {
        service.addProfessor(professorDTO);
    }

    @PutMapping(path = "{id}")
    public void editProfessor(@PathVariable final long id, @RequestBody final ProfessorDTO professorDTO) {
        service.updateProfessor(id, professorDTO);
    }

    @GetMapping(path = "{id}")
    @CrossOrigin
    public ProfessorDTO getProfessorById(@PathVariable final long id) {
        return service.getProfessorDTOById(id);
    }

    @GetMapping(path="{id}/courses")
    @CrossOrigin
    public Set<CourseDTO> getCourses(@PathVariable final long id) {
        return service.getCourses(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCourseById(@PathVariable final long id) {
        service.deleteProfessor(id);
    }
}

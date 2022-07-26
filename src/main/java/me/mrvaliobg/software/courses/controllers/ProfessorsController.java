package me.mrvaliobg.software.courses.controllers;

import lombok.RequiredArgsConstructor;
import me.mrvaliobg.software.courses.dto.ProfessorDTO;
import me.mrvaliobg.software.courses.services.ProfessorService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/professors")
public class ProfessorsController {

    private final ProfessorService service;

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
    public void getProfessorById(@PathVariable final long id) {
        service.getProfessorById(id);
    }


}

package me.mrvaliobg.software.courses.services;

import lombok.AllArgsConstructor;
import me.mrvaliobg.software.courses.dto.DTOConverter;
import me.mrvaliobg.software.courses.dto.ProfessorDTO;
import me.mrvaliobg.software.courses.exceptions.NoProfessorException;
import me.mrvaliobg.software.courses.models.Course;
import me.mrvaliobg.software.courses.models.Professor;
import me.mrvaliobg.software.courses.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class ProfessorService {
    private final ProfessorRepository repository;
    private final DTOConverter dtoConverter;

    public Professor getProfessorById(long professorId) {
        return repository.findById(professorId).orElseThrow(NoProfessorException::new);
    }

    public void addProfessor(ProfessorDTO professorDTO) {
        repository.save(dtoConverter.convertDtoToEntity(professorDTO));
    }

    public void updateProfessor(long id, ProfessorDTO professorDTO) {
        Professor professor = repository.findById(id).orElseThrow(NoProfessorException::new);
        professor.setFirstName(professorDTO.getFirstName());
        professor.setFirstName(professorDTO.getLastName());
        professor.setCourses(professorDTO.getCourses());
    }

    public Set<Course> getCourses(long id) {
        Professor professor = repository.findById(id).orElseThrow(NoProfessorException::new);
        return professor.getCourses();
    }

    public void deleteProfessor(long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        } else throw new NoProfessorException();
    }

    public List<Professor> getAllProfessors() {
        return repository.findAll();
    }
}

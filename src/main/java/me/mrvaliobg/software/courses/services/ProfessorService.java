package me.mrvaliobg.software.courses.services;

import lombok.AllArgsConstructor;
import me.mrvaliobg.software.courses.dto.CourseDTO;
import me.mrvaliobg.software.courses.dto.DTOConverter;
import me.mrvaliobg.software.courses.dto.ProfessorDTO;
import me.mrvaliobg.software.courses.exceptions.NoProfessorException;
import me.mrvaliobg.software.courses.models.Course;
import me.mrvaliobg.software.courses.models.Professor;
import me.mrvaliobg.software.courses.repository.CourseRepository;
import me.mrvaliobg.software.courses.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final CourseRepository courseRepository;
    private final DTOConverter dtoConverter;

    public ProfessorDTO getProfessorDTOById(long professorId) {
        return dtoConverter.convertEntityToDTO(professorRepository.findById(professorId).orElseThrow(NoProfessorException::new));
    }

    public Professor getProfessorById(long professorId) {
        return professorRepository.findById(professorId).orElseThrow(NoProfessorException::new);
    }

    public void addProfessor(ProfessorDTO professorDTO) {
        professorRepository.save(dtoConverter.convertDtoToEntity(professorDTO));
    }

    public void updateProfessor(long id, ProfessorDTO professorDTO) {
        Professor professor = professorRepository.findById(id).orElseThrow(NoProfessorException::new);
        professor.setFirstName(professorDTO.getFirstName());
        professor.setFirstName(professorDTO.getLastName());
        professor.setCourses(professorDTO.getCourses());
    }

    public Set<CourseDTO> getCourses(long id) {
        Professor professor = professorRepository.findById(id).orElseThrow(NoProfessorException::new);
        return professor.getCourses().stream().map(dtoConverter::convertEntityToDTO).collect(Collectors.toSet());
    }

    public void deleteProfessor(long id) {
        Professor professor = professorRepository.findById(id).orElseThrow(NoProfessorException::new);
        Set<Course> courses = professor.getCourses();
        for (Course course : courses) {
            course.setProfessor(null);
            courseRepository.save(course);
        }
        professorRepository.deleteById(id);
    }

    public List<ProfessorDTO> getAllProfessors() {
        return professorRepository.findAll().stream().map(dtoConverter::convertEntityToDTO).collect(Collectors.toList());
    }
}

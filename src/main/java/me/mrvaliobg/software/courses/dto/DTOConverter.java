package me.mrvaliobg.software.courses.dto;

import me.mrvaliobg.software.courses.models.Course;
import me.mrvaliobg.software.courses.models.Professor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("DTOConverter")
public class DTOConverter {

    public CourseDTO convertEntityToDTO(Course course) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(course, CourseDTO.class);
    }

    public ProfessorDTO convertEntityToDTO(Professor professor) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(professor, ProfessorDTO.class);
    }
    public Course convertDtoToEntity(CourseDTO courseDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(courseDTO, Course.class);
    }

    public Professor convertDtoToEntity(ProfessorDTO professorDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(professorDTO, Professor.class);
    }

}

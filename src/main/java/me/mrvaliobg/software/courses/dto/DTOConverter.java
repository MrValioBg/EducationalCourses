package me.mrvaliobg.software.courses.dto;

import me.mrvaliobg.software.courses.models.Course;
import me.mrvaliobg.software.courses.models.Professor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DTOConverter {

    public CourseDTO convertEntityToDto(Course course) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(course, CourseDTO.class);
    }

    public Course convertDtoToEntity(CourseDTO courseDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(courseDTO, Course.class);
    }

    public ProfessorDTO convertEntityToDto(Professor professor) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(professor, ProfessorDTO.class);
    }

    public Professor convertDtoToEntity(ProfessorDTO professor) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(professor, Professor.class);
    }

}

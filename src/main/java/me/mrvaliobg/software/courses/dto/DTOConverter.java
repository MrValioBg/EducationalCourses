package me.mrvaliobg.software.courses.dto;

import me.mrvaliobg.software.courses.models.Course;
import me.mrvaliobg.software.courses.models.Professor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DTOConverter {

    public Course convertDtoToEntity(CourseDTO courseDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(courseDTO, Course.class);
    }

    public Professor convertDtoToEntity(ProfessorDTO professorDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(professorDTO, Professor.class);
    }

}

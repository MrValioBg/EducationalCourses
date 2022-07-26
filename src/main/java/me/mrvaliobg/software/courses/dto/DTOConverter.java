package me.mrvaliobg.software.courses.dto;

import me.mrvaliobg.software.courses.models.Course;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("DTOConverter")
public class DTOConverter {

    public CourseDTO convertEntityToDto(Course course) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(course, CourseDTO.class);
    }

    public Course convertDtoToEntity(CourseDTO courseDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(courseDTO, Course.class);
    }


}

package me.mrvaliobg.software.courses.dto;

import lombok.Data;
import me.mrvaliobg.software.courses.models.Course;

import java.util.Set;

@Data
public class ProfessorDTO {

    private long id;
    private String firstName;
    private String lastName;
    private Set<Course> courses;

}

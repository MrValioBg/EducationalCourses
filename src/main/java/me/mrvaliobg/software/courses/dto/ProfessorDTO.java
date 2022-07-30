package me.mrvaliobg.software.courses.dto;

import lombok.Data;
import me.mrvaliobg.software.courses.models.Course;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class ProfessorDTO {

    private long id;
    @NotNull(message = "First Name cannot be null")
    private String firstName;
    @NotNull(message = "Last Name cannot be null")
    private String lastName;
    private Set<Course> courses;

}

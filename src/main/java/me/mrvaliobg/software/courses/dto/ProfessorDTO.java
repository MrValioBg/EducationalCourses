package me.mrvaliobg.software.courses.dto;

import lombok.Data;
import me.mrvaliobg.software.courses.models.Course;
import me.mrvaliobg.software.courses.models.enums.AttendingType;
import me.mrvaliobg.software.courses.models.enums.Field;
import me.mrvaliobg.software.courses.models.enums.Status;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
public class ProfessorDTO {

    private long id;
    private String firstName;
    private String lastName;
    private Set<Course> courses;

}

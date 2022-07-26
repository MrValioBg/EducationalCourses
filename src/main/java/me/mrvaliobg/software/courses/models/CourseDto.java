package me.mrvaliobg.software.courses.models;

import lombok.Data;
import me.mrvaliobg.software.courses.models.enums.AttendingType;
import me.mrvaliobg.software.courses.models.enums.Field;
import me.mrvaliobg.software.courses.models.enums.Status;

import java.io.Serializable;

@Data
public class CourseDto implements Serializable {
    private final long id;
    private final String title;
    private final String description;
    private final Status status;
    private final AttendingType type;
    private final Field field;
    private final ProfessorDto professor;
}

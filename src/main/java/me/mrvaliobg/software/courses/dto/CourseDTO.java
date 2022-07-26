package me.mrvaliobg.software.courses.dto;

import lombok.Data;
import me.mrvaliobg.software.courses.models.Professor;
import me.mrvaliobg.software.courses.models.enums.AttendingType;
import me.mrvaliobg.software.courses.models.enums.Field;
import me.mrvaliobg.software.courses.models.enums.Status;

@Data
public class CourseDTO {
    private long id;
    private String title;
    private String description;
    private Status status;
    private AttendingType type;
    private Field field;
    private Professor professor;
}

package me.mrvaliobg.software.courses.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProfessorDto implements Serializable {
    private final long id;
    private final String firstName;
    private final String lastName;
}

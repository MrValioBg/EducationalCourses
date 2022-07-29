package me.mrvaliobg.software.courses.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.mrvaliobg.software.courses.models.enums.AttendingType;
import me.mrvaliobg.software.courses.models.enums.Field;
import me.mrvaliobg.software.courses.models.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Title cannot be null")
    private String title;
    @Column(length = 1000)
    private String description;

    private Status status;
    private AttendingType attendingType;
    private Field field;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id",referencedColumnName = "id")
    private Professor professor;

}
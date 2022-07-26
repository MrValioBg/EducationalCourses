package me.mrvaliobg.software.courses.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import me.mrvaliobg.software.courses.models.enums.AttendingType;
import me.mrvaliobg.software.courses.models.enums.Field;
import me.mrvaliobg.software.courses.models.enums.Status;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    @Column(length = 1000)
    private String description;

    private Status status;
    private AttendingType type;
    private Field field;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Professor professor;

}

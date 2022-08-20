package me.mrvaliobg.software.courses.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.mrvaliobg.software.courses.models.enums.AttendingType;
import me.mrvaliobg.software.courses.models.enums.Field;
import me.mrvaliobg.software.courses.models.enums.Status;

import javax.persistence.*;

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

    private String title;
    @Column(length = 1000)
    private String description;

    private Status status;
    private AttendingType attendingType;
    private Field field;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Professor professor;

}
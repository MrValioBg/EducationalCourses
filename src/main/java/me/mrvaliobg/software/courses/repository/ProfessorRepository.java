package me.mrvaliobg.software.courses.repository;

import me.mrvaliobg.software.courses.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Course, Long> {

}

package me.mrvaliobg.software.courses.repository;

import me.mrvaliobg.software.courses.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}

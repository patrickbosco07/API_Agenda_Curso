package com.leandersonandre.agenda.core.repository;

import com.leandersonandre.agenda.core.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{
}

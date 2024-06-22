package com.leandersonandre.agenda.core.repository;

import com.leandersonandre.agenda.core.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}

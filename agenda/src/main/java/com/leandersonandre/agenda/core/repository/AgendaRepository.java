package com.leandersonandre.agenda.core.repository;

import com.leandersonandre.agenda.core.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Agenda,Long> {
}

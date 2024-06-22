package com.leandersonandre.agenda.core.service;

import com.leandersonandre.agenda.core.entity.Agenda;
import com.leandersonandre.agenda.core.entity.Professor;
import com.leandersonandre.agenda.core.repository.AgendaRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AgendaServico {
    @Autowired
    AgendaRepository agendaRepository;

    public List<Agenda> buscarData(){return agendaRepository.findAll();}

    public Optional<Agenda> obterPeloId(Long id) { return agendaRepository.findById(id); }

    public void salvar(Agenda agenda){
        if(Strings.isBlank(agenda.getDia())){
            throw new RuntimeException("Favor informar o dia");
        }
        if(Strings.isBlank(agenda.getMateria())){
            throw new RuntimeException("Favor informar a matéria");
        }
        if(Strings.isBlank(agenda.getSala())){
            throw new RuntimeException("Favor informar a sala");
        }
        agendaRepository.save(agenda);


    }

    /*public Agenda atualizarAgenda(Long id, Agenda agenda) {
        Optional<Agenda> agendaOptional = agendaRepository.findById(id);
        if (agendaOptional.isPresent()){
            return agendaRepository.save(agenda);
        } else {throw new NoSuchElementException("Agenda não encontrada");}
    }*/

    public void deletarAgenda(Long id) {
        agendaRepository.deleteById(id);
    }
}

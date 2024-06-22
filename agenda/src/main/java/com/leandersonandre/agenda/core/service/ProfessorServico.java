package com.leandersonandre.agenda.core.service;

import com.leandersonandre.agenda.core.entity.Professor;
import com.leandersonandre.agenda.core.repository.ProfessorRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProfessorServico {

    @Autowired
    ProfessorRepository professorRepository;

    public List<Professor> obterTodos() {
        return professorRepository.findAll();
    }

    public Optional<Professor> obterPeloId(Long id) { return professorRepository.findById(id); }

    public void salvar(Professor professor){
        if(Strings.isBlank(professor.getNome())){
            throw new RuntimeException("Favor informar o nome");
        }
        if(Strings.isBlank(professor.getSobrenome())){
            throw new RuntimeException("Favor informar o sobrenome");
        }
        professorRepository.save(professor);


    }

    /*public Professor atualizarProfessor(Long id, Professor professor) {
        Optional<Professor> professorOptional = professorRepository.findById(id);
        if (professorOptional.isPresent()){
            return professorRepository.save(professor);
        } else {throw new NoSuchElementException("Usuário não encontrado");}
    }*/

    public void deletarProfessor(Long id) {
        professorRepository.deleteById(id);
    }

}

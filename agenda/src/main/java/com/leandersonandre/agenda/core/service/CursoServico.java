package com.leandersonandre.agenda.core.service;

import com.leandersonandre.agenda.core.entity.Agenda;
import com.leandersonandre.agenda.core.entity.Curso;
import com.leandersonandre.agenda.core.entity.Professor;
import com.leandersonandre.agenda.core.repository.CursoRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CursoServico {

    @Autowired
    CursoRepository cursoRepository;

    public List<Curso> obterTodos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> obterPeloId(Long id) { return cursoRepository.findById(id); }

    public void salvar(Curso curso){
        if(Strings.isBlank(curso.getNome())){
            throw new RuntimeException("Favor informar o nome do curso");
        }
        if(Strings.isBlank(curso.getAgenda())){
            throw new RuntimeException("Favor informar a agenda do curso");
        }
        if(Strings.isBlank(curso.getProfessor())){
            throw new RuntimeException("Favor informar o professor do curso");
        }
        if(Strings.isBlank(curso.getTurma())){
            throw new RuntimeException("Favor informar a turma do curso");
        }
        cursoRepository.save(curso);


    }

    /*public Curso atualizarCurso(Long id, Curso curso) {
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        if (cursoOptional.isPresent()){
            return cursoRepository.save(curso);
        } else {throw new NoSuchElementException("Curso não encontrada");}
    }*/

    public void deletarCurso(Long id) {cursoRepository.deleteById(id);
    }
}

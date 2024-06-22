package com.leandersonandre.agenda.core.service;

import com.leandersonandre.agenda.core.entity.Curso;
import com.leandersonandre.agenda.core.entity.Professor;
import com.leandersonandre.agenda.core.entity.Turma;
import com.leandersonandre.agenda.core.repository.CursoRepository;
import com.leandersonandre.agenda.core.repository.TurmaRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TurmaServico {

    @Autowired
    TurmaRepository turmaRepository;

    public List<Turma> obterTodos() {
        return turmaRepository.findAll();
    }

    public Optional<Turma> obterPeloId(Long id) { return turmaRepository.findById(id); }

    public void salvar(Turma turma){
        if(Strings.isBlank(turma.getCodigo())){
            throw new RuntimeException("Favor informar o código da turma");
        }
        if(Strings.isBlank(turma.getSemestre())){
            throw new RuntimeException("Favor informar o semestre da turma");
        }
        turmaRepository.save(turma);


    }

    /*public Turma atualizarTurma(Long id, Turma turma) {
        Optional<Turma> turmaOptional = turmaRepository.findById(id);
        if (turmaOptional.isPresent()){
            return turmaRepository.save(turma);
        } else {throw new NoSuchElementException("Turma não encontrada");}
    }*/

    public void deletarTurma(Long id) {turmaRepository.deleteById(id);
    }
}

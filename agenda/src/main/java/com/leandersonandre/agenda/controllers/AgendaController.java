package com.leandersonandre.agenda.controllers;

import com.leandersonandre.agenda.core.entity.Agenda;
import com.leandersonandre.agenda.core.entity.Professor;
import com.leandersonandre.agenda.core.service.AgendaServico;
import com.leandersonandre.agenda.core.service.ProfessorServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

@Controller
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    AgendaServico agendaServico;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("agenda/index.html");
        view.addObject("objeto","olá thymeleaf");
        view.addObject("agendas",agendaServico.buscarData());
        return view;
    }

    @GetMapping("/{id}")
    public ModelAndView visualizar(@PathVariable("id") long id){
        ModelAndView view = new ModelAndView("agenda/visualizar.html");
        var opt = agendaServico.obterPeloId(id);
        opt.ifPresent(entidade -> view.addObject("entidade", entidade));
        return view;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable("id") long id){
        ModelAndView view = new ModelAndView("agenda/editar.html");
        var opt = agendaServico.obterPeloId(id);
        opt.ifPresent(entidade -> view.addObject("entidade", entidade));
        return view;
    }



    @GetMapping("/criar")
    public ModelAndView criarNovaAgenda(){
        ModelAndView view = new ModelAndView("agenda/criar.html");
        view.addObject("entidade", new Agenda());
        return view;
    }

    @GetMapping("/{id}/deletar")
    public ModelAndView deletar(@PathVariable("id") long id){
        ModelAndView view = new ModelAndView("agenda/deletar.html");
        return view;
    }

    @PostMapping("/atualizar")
    public ModelAndView salvar(@ModelAttribute("entidade")Agenda agenda){
        try {
            agendaServico.salvar(agenda);
            return new ModelAndView("redirect:/agenda/"+agenda.getId());
        }catch (Exception e){
            ModelAndView model = new ModelAndView("agenda/editar.html");
            model.addObject("erro",e.getMessage());
            model.addObject("entidade", agenda);
            return model;
        }
    }


    @PostMapping("/criar")
    public ModelAndView criar(@ModelAttribute("entidade")Agenda agenda){
        try {
            System.out.println(agenda);
            agenda.setId(0);
            agendaServico.salvar(agenda);
            return new ModelAndView("redirect:/agenda/"+agenda.getId());
        }catch (Exception e){
            ModelAndView model = new ModelAndView("agenda/criar.html");
            model.addObject("erro",e.getMessage());
            model.addObject("entidade", agenda);
            return model;
        }
    }

    @DeleteMapping("/{id}")
    public ModelAndView deletarAgenda(@PathVariable("id") long id){
        try {
            agendaServico.deletarAgenda(id);
            return new ModelAndView("redirect:/agenda");
        }catch (Exception e){
            ModelAndView model = new ModelAndView("agenda/deletar.html");
            model.addObject("erro",e.getMessage());
            return model;
        }
    }

}

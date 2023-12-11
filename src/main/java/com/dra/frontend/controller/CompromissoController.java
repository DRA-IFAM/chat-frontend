package com.dra.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dra.frontend.model.Compromisso;
import com.dra.frontend.service.CompromissoService;



@Controller
@RequestMapping("/compromisso")
public class CompromissoController {

    @Autowired
    CompromissoService compromissoService;
    
    @PostMapping("/{id}")
    public String negarContato(@PathVariable long id, @Validated Compromisso compromisso, BindingResult result, Model model) {
    	 compromissoService.postCompromisso(compromisso);
    	return "redirect:/compromisso";
    }
    
    @PutMapping("/{id}")
    public String cancelarContato(@PathVariable long id, @Validated Compromisso compromisso, BindingResult result, Model model) {
    	 compromissoService.putCompromisso(id, compromisso);
    	return "redirect:/compromisso";
    }
}

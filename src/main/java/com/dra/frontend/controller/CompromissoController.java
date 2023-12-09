package com.dra.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dra.frontend.service.CompromissoService;



@Controller
@RequestMapping("/compromisso")
public class CompromissoController {

    @Autowired
    CompromissoService compromissoService;
	
    @PostMapping("/negar")
    public String negarCompromisso(@RequestParam("id") long id) {
        compromissoService.negarCompromisso(id);
        return "redirect:/compromisso";
    }

    @PutMapping("/cancelar")
    public String cancelarCompromisso(@RequestParam("id") long id) {
        compromissoService.cancelarCompromisso(id);
        return "redirect:/compromisso";
    }
	
}

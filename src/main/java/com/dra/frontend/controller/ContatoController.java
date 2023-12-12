package com.dra.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dra.frontend.service.ContatoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/contato")
public class ContatoController {
    @Autowired
    ContatoService contatoService;

    @GetMapping
    public String getContatos(Model model) {
        model.addAttribute("contatos", contatoService.getContatos());
        return "listaContato.html";
    }

    @GetMapping("/{email}")
    public String getContato(@RequestParam String email, Model model) {
        model.addAttribute("contato", contatoService.getContato(email));
        return "contato/visualizar";
    }


    
    
}

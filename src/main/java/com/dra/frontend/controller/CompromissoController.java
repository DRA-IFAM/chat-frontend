package com.dra.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dra.frontend.service.CompromissoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import com.dra.frontend.model.Compromisso;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("/compromisso")
public class CompromissoController {

    @Autowired
    CompromissoService compromissoService;

    @GetMapping
    public String listaCompromissos(Model model){
        model.addAttribute("compromissos", compromissoService.listaCompromissos());
        return "listaCompromissos.html";
    }

    @GetMapping("/criar")
    public String criarCompromisso(Compromisso compromisso){
        return "criaCompromisso.html";
    }

    @GetMapping("/detalha/{id}")
    public String detalhaCompromisso(@PathVariable  Long id, Model model){
        model.addAttribute("compromisso", compromissoService.detalhaCompromisso(id));
        return "visualizarCompromisso";
    }

    @PostMapping
    public String criaCompromisso(Compromisso compromisso){
        compromissoService.criaCompromisso(compromisso);
        return "listaCompromissos";
    }
    
    @DeleteMapping("/{id}")
    public String deletaCompromisso(@RequestParam("compromissoId") Long compromissoId){
        compromissoService.deletaCompromisso(compromissoId);
        return "redirect:/compromisso";
    }

    @PostMapping("/aceitar/{id}")
    public String aceitarCompromisso(@RequestParam("compromissoId") Long compromissoId){
        //compromissoService.aceitarCompromisso(compromissoId);
        return "redirect:/compromisso";
    }
    
    @PostMapping("/recusar/{id}")
    public String recusarCompromisso(@RequestParam("compromissoId") Long compromissoId){
        //compromissoService.recusarCompromisso(compromissoId);
        return "redirect:/compromisso";
    }

    @PostMapping("/cancelar/{id}")
    public String cancelarCompromisso(@RequestParam("compromissoId") Long compromissoId){
        //compromissoService.cancelarCompromisso(compromissoId);
        return "redirect:/compromisso";
    }
    
    
}

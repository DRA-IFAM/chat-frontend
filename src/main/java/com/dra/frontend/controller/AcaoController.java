package com.dra.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dra.frontend.service.AcaoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import com.dra.frontend.model.Acao;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@RequestMapping("/acao")
public class AcaoController {

    @Autowired
    AcaoService acaoService;

    @GetMapping("/{compromissoId}")
    public String getPaginaGerenciarAcao(@PathVariable Long compromissoId,  Model model) {
        //model.addAttribute("acoes", acaoService.listaAcoes(compromissoId));
        return "gerenciarAcoes.html";
    }

    @PostMapping
    public String criaAcao(Acao acao) {
        //acaoService.criaAcao(acao);
        return "redirect:/acao";
    }
    
    @DeleteMapping("/{id}")
    public String deletaAcao(@PathVariable Long acaoId){
        //acaoService.deletaAcao(acaoId);
        return "redirect:/acao";
    }

    @PutMapping("/{id}")
    public String atualizaAcao(Acao acao){
        //acaoService.atualizaAcao(acao);
        return "redirect:/acao";
    }
    

    
}

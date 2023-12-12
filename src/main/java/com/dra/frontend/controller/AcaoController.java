package com.dra.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dra.frontend.service.AcaoService;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/acao")
public class AcaoController {

    @Autowired
    AcaoService acaoService;

    @GetMapping
    public String getPaginaGerenciarAcao() {
        return "gerenciarAcoes.html";
    }
    
    
}

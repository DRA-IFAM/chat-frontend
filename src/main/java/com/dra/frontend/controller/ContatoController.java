package com.dra.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dra.frontend.service.ContatoService;

import org.springframework.beans.factory.annotation.Autowired;



@Controller
@RequestMapping("/contato")
public class ContatoController {
    @Autowired
    ContatoService contatoService;
    
}

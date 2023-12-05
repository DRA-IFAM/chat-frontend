package com.dra.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dra.frontend.service.CompromissoService;



@Controller
@RequestMapping("/compromisso")
public class CompromissoController {

    @Autowired
    CompromissoService compromissoService;
    
}

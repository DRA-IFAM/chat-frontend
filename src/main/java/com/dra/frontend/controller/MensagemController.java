package com.dra.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dra.frontend.service.MensagemService;

import org.springframework.beans.factory.annotation.Autowired;



@Controller
@RequestMapping("/mensagem")
public class MensagemController {
    
    @Autowired
    MensagemService mensagemService;
}

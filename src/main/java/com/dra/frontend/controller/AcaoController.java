package com.dra.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dra.frontend.service.AcaoService;


@Controller
@RequestMapping("/acao")
public class AcaoController {

    @Autowired
    AcaoService acaoService;
    
}

package com.dra.frontend.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("/")
    public String getPaginaIndex(Model model) {
        return "dashboard.html";
    }

    
}

package com.dra.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dra.frontend.model.Mensagem;
import com.dra.frontend.service.MensagemService;
import com.dra.frontend.service.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/mensagem")
public class MensagemController {
    
    @Autowired
    MensagemService mensagemService;

  

    @GetMapping("/enviar")
    public String enviarMensagem(Mensagem mensagem){
        return "enviarMensagem";
    }

    @PostMapping
    public String getMensagens(Mensagem mensagem, BindingResult result, Model model) {
        mensagemService.postMensagem(mensagem);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteMensagem(Long id) {
        mensagemService.deletarMensagem(id);
        return "redirect:/";
    }

    @GetMapping
    public String getMensagens(Model model) {
        model.addAttribute("mensagens", mensagemService.getMensagens());
        return "listarMensagens";
    }
}

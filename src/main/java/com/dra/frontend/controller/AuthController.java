package com.dra.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.dra.frontend.model.Usuario;
import com.dra.frontend.service.AuthService;
import com.dra.frontend.service.UserSession;

import org.springframework.ui.Model;


@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @Autowired
    UserSession userSession;

    @GetMapping("/login")
    public String getPaginaLogin(Usuario usuario, Model model) {
        return "login.html";
    }

    @PostMapping("/login")
    public String postLogin(Usuario usuario) {
       try{
            String token = authService.logar(usuario.getEmail(), usuario.getSenha());
            userSession.setToken(token);
       }catch(Exception e){
           return "redirect:/auth/login?error";
         }
        return "redirect:/mensagem"; 
    } 


    @GetMapping("/registrar")
    public String getPaginaRegistro(Usuario usuario, Model model) {
        return "registro.html";
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/auth/login";
    }

    @PostMapping("/registrar")
    public String postRegistrar(Usuario usuario) {
        String statusCode  = authService.cadastrar(usuario);
        if(statusCode.equals("200")){
            return "redirect:/auth/login?sucesso";
        }
        return "redirect:/auth/login?registerError";
    }

    
    
    
}

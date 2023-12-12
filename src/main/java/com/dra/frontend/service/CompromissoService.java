package com.dra.frontend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dra.frontend.model.Compromisso;

@Service
public class CompromissoService {

    
    @Autowired
    UserSession userSession;
    
    private final String backendCompromissoURI= "http://localhost:8080/api/compromisso";

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    private HttpHeaders createHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);
        try{
            headers.add("Authorization", "Bearer " + userSession.getToken());
        }catch(Exception e){
            System.out.println("Erro ao criar header");
        }
        return headers;
    }

        public List<Compromisso> listaAcoes() {
        return null;
    }

    public Compromisso detalhaCompromisso(Long compromissoId) {
        return null;
    }

    public String criaCompromisso(Compromisso compromisso) {
        HttpEntity<Compromisso> requestBody = new HttpEntity<Compromisso>(compromisso, createHttpHeaders());
        ResponseEntity<Compromisso> response = restTemplate.postForEntity(backendCompromissoURI, requestBody, Compromisso.class);
        return response.getStatusCode().toString();
    }

    public String deletaCompromisso(Long compromissoId) {
        return null;
    }

    public String atualizaCompromisso(Compromisso compromisso) {
        return null;
    }
    
}

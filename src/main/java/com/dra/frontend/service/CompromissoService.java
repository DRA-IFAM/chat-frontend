package com.dra.frontend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
        addAuthToHeaders(headers);
        return headers;
    }

    private HttpHeaders addAuthToHeaders(HttpHeaders headers){
        try{
            headers.add("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJicmVub2dvbnphZ2EiLCJleHAiOjE3MDI1NzIwMjIsImlzcyI6IlVFQS1GaWxlLVNoYXJpbmcifQ.2ADsh0gVwNxcNMBi7gI6XCUGMeQNNNU84P-j31rYcvs");
        }catch(Exception e){
            System.out.println("Erro ao criar header");
        }
        return headers;
    }


    public Compromisso detalhaCompromisso(Long compromissoId) {
         HttpHeaders headers = new HttpHeaders();
        addAuthToHeaders(headers);
        String recurso = backendCompromissoURI + "/" + compromissoId;
        HttpEntity<Object> requestBody = new HttpEntity<Object>(headers);
        ResponseEntity<Compromisso> response = restTemplate.exchange(recurso, HttpMethod.GET, requestBody, Compromisso.class);
        return response.getBody();
    }

    public String criaCompromisso(Compromisso compromisso) {
        HttpHeaders headers1 = createHttpHeaders();
        HttpEntity<Compromisso> requestBody = new HttpEntity<Compromisso>(compromisso, headers1);
        ResponseEntity<String> response = restTemplate.postForEntity(backendCompromissoURI, requestBody, String.class);
        return response.getStatusCode().toString();
    }

    public List<Object> listaCompromissos() {
        HttpHeaders headers = new HttpHeaders();
        addAuthToHeaders(headers);
        String recurso = backendCompromissoURI;
        HttpEntity<Object> requestBody = new HttpEntity<Object>(headers);
        ResponseEntity<Object[]> response = restTemplate.exchange(recurso, HttpMethod.GET, requestBody, Object[].class);
        if(response == null) return null;
        return List.of(response.getBody());
    }

    public String editaCompromisso(Compromisso compromisso, Long compromissoId) {
        String recurso = backendCompromissoURI + "/" + compromissoId;
        HttpEntity<Compromisso> requestBody = new HttpEntity<Compromisso>(compromisso, createHttpHeaders());
        ResponseEntity<Compromisso> response = restTemplate.exchange( recurso, HttpMethod.PUT, requestBody, Compromisso.class);
        return response.getStatusCode().toString();
    }

    public String deletaCompromisso(Long compromissoId) {
        String recurso = backendCompromissoURI + "/" + compromissoId;
        HttpEntity<Compromisso> requestBody = new HttpEntity<Compromisso>(createHttpHeaders());
        ResponseEntity<Object> response = restTemplate.exchange( recurso, HttpMethod.DELETE, requestBody, Object.class);
        return response.getStatusCode().toString();
    }

    public String aceitarCompromisso(Long compromissoId) {
        String recurso = backendCompromissoURI + "/aceitar/" + compromissoId;
        HttpEntity<Compromisso> requestBody = new HttpEntity<Compromisso>(createHttpHeaders());
        ResponseEntity<Object> response = restTemplate.postForEntity(recurso, requestBody, Object.class);
        return response.getStatusCode().toString();
        }

    public String recusarCompromisso(Long compromissoId) {
        String recurso = backendCompromissoURI + "/negar/" + compromissoId;
        HttpEntity<Compromisso> requestBody = new HttpEntity<Compromisso>(createHttpHeaders());
        ResponseEntity<Object> response = restTemplate.postForEntity(recurso, requestBody, Object.class);
        return response.getStatusCode().toString();
    }

    public String cancelarCompromisso(Long compromissoId) {
        String recurso = backendCompromissoURI + "/cancelar/" + compromissoId;
        HttpEntity<Compromisso> requestBody = new HttpEntity<Compromisso>(createHttpHeaders());
        ResponseEntity<Object> response = restTemplate.exchange( recurso, HttpMethod.PUT, requestBody, Object.class);
        return response.getStatusCode().toString();
    }
    
}

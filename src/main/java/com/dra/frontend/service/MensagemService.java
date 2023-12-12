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
import java.util.Arrays;

import com.dra.frontend.model.Contato;
import com.dra.frontend.model.Mensagem;

@Service
public class MensagemService {

  private final String backendMensagemURI= "http://localhost:8080/api/mensagem";
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    @Autowired
    UserSession userSession;
    
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

    public List<Object> getMensagens( ) {
        HttpEntity<Object> requestBody = new HttpEntity<Object>(createHttpHeaders());
        ResponseEntity<Object[]> response = restTemplate.exchange(backendMensagemURI, HttpMethod.GET, requestBody, Object[].class);
        
        if(response == null) return new ArrayList<Object>();
        return new ArrayList<Object>(Arrays.asList(response.getBody()));
    }
    
    public String  postMensagem(Mensagem mensagem) {
        HttpEntity<Mensagem> requestBody = new HttpEntity<Mensagem>(mensagem, createHttpHeaders());
        ResponseEntity<Mensagem> response = restTemplate.postForEntity(backendMensagemURI, requestBody, Mensagem.class);
        return response.getStatusCode().toString();
    }
    
    public void deletarMensagem(Long mensagemId) {
        String resource = backendMensagemURI + mensagemId;
        HttpEntity<Contato> requestBody = new HttpEntity<>(createHttpHeaders());
        restTemplate.exchange(resource, HttpMethod.DELETE, requestBody, Object.class);
    }

    public Mensagem getMensagem(Long mensagemId) {
        Mensagem mensagem = restTemplate.getForObject( backendMensagemURI + mensagemId, Mensagem.class);
        return mensagem;
    }
  
}

package com.dra.frontend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.dra.frontend.model.Acao;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AcaoService {
    
    
    @Autowired
    UserSession userSession;
    private final String backendMensagemURI= "http://localhost:8080/api/acao";
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
            headers.add("Authorization", "Bearer " + userSession.getToken());
        }catch(Exception e){
            System.out.println("Erro ao criar header");
        }
        return headers;
    }

    public List<Object> listaAcoes(Long compromissoId) {
        HttpHeaders headers = new HttpHeaders();
        addAuthToHeaders(headers);
        HttpEntity<Object> requestBody = new HttpEntity<Object>(headers);
        ResponseEntity<Object[]> response = restTemplate.exchange(backendMensagemURI+"/"+compromissoId, HttpMethod.GET, requestBody, Object[].class);
        
        if(response == null) return new ArrayList<Object>();
        return new ArrayList<Object>(Arrays.asList(response.getBody()));
    }

    public Acao detalhaAcao(Long acaoId) {
        return null;
    }

    public String criaAcao(Acao acao) {
        HttpEntity<Acao> requestBody = new HttpEntity<Acao>(acao, createHttpHeaders());
        ResponseEntity<Acao> response = restTemplate.postForEntity(backendMensagemURI, requestBody, Acao.class);
        return response.getStatusCode().toString();
    }

    public String deletaAcao(Long acaoId) {
        HttpHeaders headers = new HttpHeaders();
        addAuthToHeaders(headers);
        HttpEntity<Object> requestBody = new HttpEntity<Object>(headers);
        ResponseEntity<Object[]> response = restTemplate.exchange(backendMensagemURI+"/"+acaoId, HttpMethod.DELETE, requestBody, Object[].class);
        return response.getStatusCode().toString();
    }

    public String atualizaAcao(Acao acao) {
        return null;
    }






}

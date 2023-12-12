package com.dra.frontend.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dra.frontend.model.Usuario;
import java.util.HashMap;
import java.util.Map;


@Service
public class AuthService {
    private final String backendMensagemURI= "http://localhost:8080/api/auth";
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    private HttpHeaders createHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }


    public String logar(String email, String senha) {
        Map <String, String> map = new HashMap<>();
        map.put("email", email);
        map.put("senha", senha);
        HttpEntity<Object> requestBody = new HttpEntity<Object>(map, createHttpHeaders());
        ResponseEntity<String> response = restTemplate.postForEntity(backendMensagemURI+"/logar", requestBody, String.class);
        return response.getBody().toString();
    }

    public String cadastrar(Usuario usuario) {
        HttpEntity<Object> requestBody = new HttpEntity<Object>(usuario , createHttpHeaders());
        ResponseEntity<String> response = restTemplate.postForEntity(backendMensagemURI+"/criar", requestBody, String.class);
        return response.getStatusCode().toString();
    }




    
}

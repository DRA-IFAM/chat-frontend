package com.dra.frontend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;

import com.dra.frontend.model.Contato;


@Service
public class ContatoService {

    @Autowired
    UserSession userSession;

    private final String backendContatoURI = "http://localhost:8080/api/contato";
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

    public Contato getContato(String email) {
        String resource = "/" + email;
        Contato contato = restTemplate.getForObject(resource, Contato.class);
        return contato;
    }

    public List<Contato> getContatos() {
        createHttpHeaders();
        Contato[] response = restTemplate.getForObject(backendContatoURI, Contato[].class);
        return new ArrayList<Contato>(Arrays.asList(response));
    }
}

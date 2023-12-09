package com.dra.frontend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompromissoService {
	
	private final String url = "http://localhost:8080/compromisso"; 
	
    public void negarCompromisso(long id) {
        RestTemplate restTemplate = new RestTemplate();
        String urlNegar = url + "/negar/" + Long.toString(id);
        restTemplate.postForObject(urlNegar, null, Void.class);
    }

    public void cancelarCompromisso(long id) {
        RestTemplate restTemplate = new RestTemplate();
        String urlCancelar = url + "/cancelar/" + Long.toString(id);
        restTemplate.put(urlCancelar, null);
    }
}
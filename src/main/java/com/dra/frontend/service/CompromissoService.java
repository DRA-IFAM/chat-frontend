package com.dra.frontend.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.dra.frontend.model.Compromisso;



@Service
public class CompromissoService {
	
	private final String url = "http://localhost:8080/contato"; 
	
	public Compromisso postCmpromisso(Compromisso compromisso) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Compromisso> requestBody = new HttpEntity<>(compromisso, headers);
		
		ResponseEntity<Compromisso> response = restTemplate.postForEntity(
				url,
				requestBody, Compromisso.class);
		
		return response.getBody();
	}
	
	public void deleteCompromisso(long id) {
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Compromisso> requestBody = new HttpEntity<>(new Compromisso(), headers);

		String urlPut = url + "/" + Long.toString(id);
		ResponseEntity<Compromisso> response =
				restTemplate.exchange(urlPut,
						HttpMethod.DELETE,
						requestBody,
						Compromisso.class);
	}
	
}

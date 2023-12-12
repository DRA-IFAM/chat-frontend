package com.dra.frontend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dra.frontend.model.Compromisso;

@Service
public class CompromissoService {

	@Autowired
	private RestTemplate restTemplate;

	private final String urlCompromisso = "http://localhost:8080/compromisso";

	public Compromisso negarCompromisso(Long id) {
		String url = urlCompromisso + "/compromisso/" + id + "/negar";
		return restTemplate.postForObject(url, null, Compromisso.class);
	}

	public Compromisso cancelarCompromisso(Long id) {
		String url = urlCompromisso + "/compromisso/" + id + "/cancelar";
		return restTemplate.postForObject(url, null, Compromisso.class);
	}
}
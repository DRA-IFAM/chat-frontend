package com.dra.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dra.frontend.model.Compromisso;
import com.dra.frontend.service.CompromissoService;

@RestController
@RequestMapping("/compromissos")
public class CompromissoController {

	@Autowired
	CompromissoService compromissoService;

	@PostMapping("/{id}/negar")
	public ResponseEntity<Compromisso> negarCompromisso(@PathVariable Long id) {
		try {
			Compromisso compromissoNegado = compromissoService.negarCompromisso(id);
			return ResponseEntity.ok(compromissoNegado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/{id}/cancelar")
	public ResponseEntity<Compromisso> cancelarCompromisso(@PathVariable Long id) {
		try {
			Compromisso compromissoCancelado = compromissoService.cancelarCompromisso(id);
			return ResponseEntity.ok(compromissoCancelado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}

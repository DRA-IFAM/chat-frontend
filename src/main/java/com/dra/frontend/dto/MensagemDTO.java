package com.dra.frontend.dto;

import com.dra.frontend.model.Contato;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MensagemDTO {
    Long id;
    String assunto;
    Contato emissor;
    Contato receptor;
    String conteudo;
    String data;
    
}

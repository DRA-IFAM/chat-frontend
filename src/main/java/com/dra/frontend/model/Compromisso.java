package com.dra.frontend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compromisso {
    private String titulo;
    private String data;
    private String local;
    private String descricao;
    private String[] convidados;
    private Acao[] acoes;
    private String status;

    
}

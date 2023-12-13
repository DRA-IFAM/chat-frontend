package com.dra.frontend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compromisso {
    private Long id;
    private String titulo;
    private String data;
    private String local;
    private String descricao;
    private String[] participantes;
    private Acao[] acoes;
    private String status;

    public Compromisso(String titulo, String data, String local, String descricao, String[] participantes) {
        this.titulo = titulo;
        this.data = data;
        this.local = local;
        this.descricao = descricao;
        this.participantes = participantes;
    }

        public Compromisso(String titulo) {

    }

        public Compromisso(Long id, String titulo, String data, String local, String descricao, String[] participantes) {
        this.id = id;
        this.titulo = titulo;
        this.data = data;
        this.local = local;
    }
    
}

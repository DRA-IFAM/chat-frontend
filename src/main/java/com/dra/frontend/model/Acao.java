package com.dra.frontend.model;


import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Acao {
    private String titulo;
    private Date dataRealizada;
    private String descricao;
    private Contato publicador;
}

package com.dra.frontend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contato {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;

    public Contato(String nome, String email, String telefone, String endereco, String bairro,
            String cidade, String estado) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Contato(String email) {
        this.email = email;
    }


    
}

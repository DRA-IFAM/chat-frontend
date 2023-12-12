package com.dra.frontend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario  {
    private String nome;
    private String senha;
    private String email;
    private String token;
    private String telefone;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String nome, String senha, String email, String telefone, String endereco, String bairro,
            String cidade, String estado) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
}

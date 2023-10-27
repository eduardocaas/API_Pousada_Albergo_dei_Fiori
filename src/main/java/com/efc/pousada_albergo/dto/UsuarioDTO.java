package com.efc.pousada_albergo.dto;

public class UsuarioDTO {

    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    public UsuarioDTO(String nome, String email, String telefone, String cpf) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
    }
}

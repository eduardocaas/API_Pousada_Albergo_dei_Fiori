package com.efc.pousada_albergo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "E-mail é obrigatório")
    @Column(nullable = false, length = 80)
    private String email;

    @NotBlank(message = "Telefone é obrigatório")
    @Column(nullable = false, length = 50)
    private String telefone;

    @NotBlank(message = "CPF é obrigatório")
    @Column(nullable = false, length = 11)
    private String cpf;

    @NotBlank(message = "Senha é obrigatória")
    @Column(nullable = false, length = 200)
    private String senha;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false)
    private Date dataNascimento;

}

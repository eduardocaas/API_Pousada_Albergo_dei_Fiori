package com.efc.pousada_albergo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false, length = 100)
    private String nome;

    @Getter
    @Email
    @NotBlank(message = "E-mail é obrigatório")
    @Column(nullable = false, length = 80, unique = true)
    private String email;

    @Getter
    @NotBlank(message = "Telefone é obrigatório")
    @Column(nullable = false, length = 50)
    private String telefone;

    @CPF
    @Getter
    @NotBlank(message = "CPF é obrigatório")
    @Column(nullable = false, length = 11, unique = true)
    private String cpf;

    @Getter
    @NotBlank(message = "Senha é obrigatória")
    @Column(nullable = false, length = 200)
    private String senha;

    @Getter
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Data de nascimento é obrigatória")
    @Column(nullable = false)
    private Date dataNascimento;

}

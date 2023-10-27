package com.efc.pousada_albergo.service;

import com.efc.pousada_albergo.domain.Usuario;
import com.efc.pousada_albergo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository)
    {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario)
    {
        this.validarUsuario(usuario);
        return usuarioRepository.save(usuario);
    }

    private void validarUsuario(Usuario usuario)
    {
        if (usuario.getNome().length() < 2)
        {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "O nome deve ter no mínimo dois (2) caracteres");
        }
        if (usuario.getTelefone().length() != 11)
        {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Informe um telefone válido, no padrão: XX 9XXXX XXXX (11 digitos)");
        }
        if (usuario.getCpf().length() != 11)
        {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Informe um CPF válido");
        }
        if (usuario.getSenha().length() < 6)
        {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "A senha deve ter no mínimo seis (6) caracteres");
        }
    }

    private void buscaPorCPF(String cpf)
    {

    }


}

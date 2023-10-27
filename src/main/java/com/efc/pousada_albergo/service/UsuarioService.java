package com.efc.pousada_albergo.service;

import com.efc.pousada_albergo.domain.Usuario;
import com.efc.pousada_albergo.dto.UsuarioDTO;
import com.efc.pousada_albergo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
public class UsuarioService {

    //TODO: EMAIL UNIQUE

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository)
    {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDTO buscaPorId(Long id)
    {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() ->
                new HttpClientErrorException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
        return new UsuarioDTO(usuario.getNome(), usuario.getEmail(), usuario.getTelefone(), usuario.getCpf());
    }

    public Usuario salvar(Usuario usuario)
    {
        this.validarUsuario(usuario);

        Optional<Usuario> usuarioCpfOptional = buscaPorCPF(usuario.getCpf());
        Optional<Usuario> usuarioEmailOptional = buscaPorEmail(usuario.getEmail());

        if (usuarioCpfOptional.isPresent())
        {
            throw new HttpClientErrorException(HttpStatus.CONFLICT,
                    "Usuário com CPF: " + usuario.getCpf() + " já cadastrado");
        }
        if (usuarioEmailOptional.isPresent())
        {
            throw new HttpClientErrorException(HttpStatus.CONFLICT,
                    "Email: " + usuario.getEmail() + " já cadastrado");
        }

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

    private Optional<Usuario> buscaPorCPF(String cpf)
    {
        return usuarioRepository.findByCpf(cpf);
    }

    private Optional<Usuario> buscaPorEmail(String email)
    {
        return usuarioRepository.findByEmail(email);
    }


}

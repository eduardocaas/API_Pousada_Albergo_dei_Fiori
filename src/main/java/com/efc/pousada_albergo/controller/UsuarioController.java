package com.efc.pousada_albergo.controller;

import com.efc.pousada_albergo.domain.Usuario;
import com.efc.pousada_albergo.dto.UsuarioDTO;
import com.efc.pousada_albergo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(@Autowired UsuarioService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<String> buscaPorId(@PathVariable Long id)
    {
        try
        {
            UsuarioDTO usuario = service.buscaPorId(id);
            return ResponseEntity.ok().body(usuario.toString());
        }
        catch (HttpClientErrorException clientException)
        {
            return ResponseEntity.status(clientException.getStatusCode()).body(clientException.getMessage());
        }
        catch (Exception exception)
        {
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<String> salvar(@Valid @RequestBody Usuario usuario)
    {
        try
        {
            Usuario obj = service.salvar(usuario);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }
        catch (HttpClientErrorException clientException)
        {
            //TODO: Testar chamada igual da buscaPorId
            return new ResponseEntity<>(clientException.getMessage(), clientException.getStatusCode());
        }
        catch (Exception exception)
        {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

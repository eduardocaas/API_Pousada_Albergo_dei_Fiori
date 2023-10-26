package com.efc.pousada_albergo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok().body("1.. 2.. 3.. Testando... ");
    }
}

package com.efc.pousada_albergo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cabana")
public class CabanaController {

    @GetMapping(value = "/{cabana}/{modeloData}")
    public ResponseEntity<String> buscaDatasCabana(@PathVariable("cabana") Integer cabana,
                                                   @PathVariable("modeloData") Integer modData)
    {
        
    }
}

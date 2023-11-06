package com.efc.pousada_albergo.controller;

import com.efc.pousada_albergo.service.CabanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/cabana")
public class CabanaController {

    private final CabanaService service;

    @Autowired
    public CabanaController(CabanaService service) {
        this.service = service;
    }

    @GetMapping(value = "/{cabana}/{modeloData}")
    public ResponseEntity<String> buscaDatasCabana(@PathVariable("cabana") Integer cabana,
                                                   @PathVariable("modeloData") Integer modData)
    {
        try
        {
            String datas = service.buscaDataCabana(cabana, modData);
            return ResponseEntity.ok().body(datas);
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
}

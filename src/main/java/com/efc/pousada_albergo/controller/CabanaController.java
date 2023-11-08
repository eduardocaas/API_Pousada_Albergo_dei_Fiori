package com.efc.pousada_albergo.controller;

import com.efc.pousada_albergo.service.CabanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cabana")
public class CabanaController {

    private final CabanaService service;

    @Autowired
    public CabanaController(CabanaService service) {
        this.service = service;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/{cabana}/{modeloData}")
    public ResponseEntity buscaDatasCabana(@PathVariable("cabana") Integer cabana,
                                                   @PathVariable("modeloData") Integer modData)
    {
        try
        {
            String datas = service.buscaDataCabana(cabana, modData);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("dates", datas);
            return ResponseEntity.ok().body(map);
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

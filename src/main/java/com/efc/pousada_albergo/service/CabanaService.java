package com.efc.pousada_albergo.service;

import com.efc.pousada_albergo.repository.CabanaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CabanaService {

    private final CabanaRepository repository;

    @Autowired
    public CabanaService(CabanaRepository repository) {
        this.repository = repository;
    }

    public String buscaDataCabana(Integer cab, Integer mod)
    {
        List<Date> datas = new ArrayList<>();

        if (cab == 1)
        {
            datas = repository.buscaDataCabana1();
        }
        else if (cab == 2)
        {
            datas = repository.buscaDataCabana2();
        }
        else if (cab == 3)
        {
            datas = repository.buscaDataCabana3();
        }
        else if (cab == 4)
        {
            datas = repository.buscaDataCabana4();
        }
        else
        {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Informe uma cabana válida (1, 2, 3 ou 4)");
        }

        if (mod == 1)
        {
            return datas.stream().map(x -> x.toString().replace("-", "")).toList().toString();
        }
        else if (mod == 2)
        {
            return datas.toString();
        }
        else
        {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Informe um modelo de data válido (1 ou 2)");
        }
    }

}

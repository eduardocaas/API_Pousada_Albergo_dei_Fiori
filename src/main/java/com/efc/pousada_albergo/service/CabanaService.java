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
            String datasRef = datas.stream().map(x -> ("'" + x.toString() + "'") ).toList().toString();
            return datasRef.replace("[", "").replace("]", "");
        }
        else if (mod == 2)
        {
            String datasRef = datas.stream().map(Date::toString).toList().toString();
            return datasRef.replace("[", "").replace("]", "");
        }
        else if (mod == 3)
        {
            return datas.stream().map(x -> x.toString().replace("-", "")).toList().toString();
        }
        else if (mod == 4)
        {
            String datasRef = datas.stream().map(x -> x.toString().replace("-", "")).toList().toString();
            return datasRef.replace("[", "").replace("]", "");

        }
        else if (mod == 5)
        {
            return datas.toString();
        }
        else if (mod == 6)
        {
            return datas.toString().replace("[", "").replace("]", "");
        }
        else
        {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Informe um modelo de data válido (1, 2, 3, 4, 5 ou 6)");
        }
    }

}

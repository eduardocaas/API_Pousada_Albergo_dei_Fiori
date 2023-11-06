package com.efc.pousada_albergo.service;

import com.efc.pousada_albergo.repository.CabanaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class CabanaService {

    private final CabanaRepository repository;

    @Autowired
    public CabanaService(CabanaRepository repository) {
        this.repository = repository;
    }

    public void buscaDataCabana()
    {
        List<Date> datas = repository.buscaDataCabana();
        System.out.println(datas.get(0));
    }

}

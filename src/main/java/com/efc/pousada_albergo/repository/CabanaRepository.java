package com.efc.pousada_albergo.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;

public interface CabanaRepository
{

    @Query(value = "CALL sp_atualizaData(:cab, :di, :df)", nativeQuery = true)
    void atualizaDataCabana(@Param("cab") Integer cabana_num, @Param("di") Date dataInicio, @Param("df") Date dataFim);
}

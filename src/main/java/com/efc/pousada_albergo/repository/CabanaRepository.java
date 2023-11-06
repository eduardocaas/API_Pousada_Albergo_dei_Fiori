package com.efc.pousada_albergo.repository;


import com.efc.pousada_albergo.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface CabanaRepository extends JpaRepository<Usuario, Integer> {
    @Query(value = "CALL sp_atualizaData(:cab, :di, :df)", nativeQuery = true)
    int atualizaDataCabana(@Param("cab") Integer cabana_num, @Param("di") Date dataInicio, @Param("df") Date dataFim);

    @Query(value = "SELECT data FROM cabana_1", nativeQuery = true)
    List<Date> buscaDataCabana1();

    @Query(value = "SELECT data FROM cabana_2", nativeQuery = true)
    List<Date> buscaDataCabana2();

    @Query(value = "SELECT data FROM cabana_3", nativeQuery = true)
    List<Date> buscaDataCabana3();

    @Query(value = "SELECT data FROM cabana_4", nativeQuery = true)
    List<Date> buscaDataCabana4();

}

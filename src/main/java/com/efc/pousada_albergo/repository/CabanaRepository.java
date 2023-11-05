package com.efc.pousada_albergo.repository;


import com.efc.pousada_albergo.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface CabanaRepository extends JpaRepository<Usuario, Integer>
{
    @Query(value = "CALL sp_atualizaData(:cab, :di, :df)", nativeQuery = true)
    int atualizaDataCabana(@Param("cab") Integer cabana_num, @Param("di") Date dataInicio, @Param("df") Date dataFim);
}

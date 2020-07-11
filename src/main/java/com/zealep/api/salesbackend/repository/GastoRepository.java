package com.zealep.api.salesbackend.repository;

import com.zealep.api.salesbackend.model.entity.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GastoRepository extends JpaRepository<Gasto,Long> {


    @Query(value = "select g from Gasto  g where g.estado=?1")
    List<Gasto> findAllActives(String estado);

    @Modifying
    @Query(value = "update Gasto g set g.estado=?2 where g.idGasto=?1")
    void deleteLogic(Long id,String estado);
}

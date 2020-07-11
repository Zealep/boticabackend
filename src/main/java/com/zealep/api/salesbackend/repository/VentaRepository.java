package com.zealep.api.salesbackend.repository;

import com.zealep.api.salesbackend.model.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VentaRepository extends JpaRepository<Venta,Long> {

    @Query("select v from Venta v where v.estado=?1")
    List<Venta> findAllActives(String estado);

    @Modifying
    @Query("update Venta v set v.estado=?2 where v.idVenta=?1")
    void deleteLogic(Long id,String estado);


}

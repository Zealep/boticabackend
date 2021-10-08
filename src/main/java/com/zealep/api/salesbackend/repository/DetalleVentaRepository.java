package com.zealep.api.salesbackend.repository;

import com.zealep.api.salesbackend.model.entity.DetalleVenta;
import com.zealep.api.salesbackend.model.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta,Long> {

    @Query("select v from DetalleVenta v where v.venta.idVenta=?1")
    List<DetalleVenta> findDetailsByVenta(Long idVenta);

}

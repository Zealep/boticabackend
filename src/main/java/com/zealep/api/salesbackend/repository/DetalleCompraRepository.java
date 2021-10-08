package com.zealep.api.salesbackend.repository;

import com.zealep.api.salesbackend.model.entity.DetalleCompra;
import com.zealep.api.salesbackend.model.entity.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DetalleCompraRepository extends JpaRepository<DetalleCompra,Long> {

    @Query("select v from DetalleCompra v where v.compra.idCompra=?1")
    List<DetalleCompra> findDetailsByCompra(Long idCompra);

    @Query("select v from DetalleCompra v where v.compra.fecha>=?1 and v.compra.fecha <=?2 and v.compra.estado=?3")
    List<DetalleCompra> findDetailsByDates(LocalDate fechaInicio,LocalDate fechaFin, String estado);

}

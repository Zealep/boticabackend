package com.zealep.api.salesbackend.service;

import com.zealep.api.salesbackend.model.entity.DetalleVenta;
import com.zealep.api.salesbackend.model.entity.Venta;

import java.time.LocalDate;
import java.util.List;

public interface VentaService {


    Venta findById(Long id);

    List<Venta> findAll();

    List<Venta> findAnuladas();

    Venta save(Venta v);

    void delete(Long id);

    boolean isExist(Long id);

    List<DetalleVenta> findDetails(Long id);

    Double getTotalByMes();

    Double getTotalByDia(LocalDate date);

    Integer obtenerUltimaVenta();

    String formatCodigoVenta(String codigo);

}

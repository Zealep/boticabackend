package com.zealep.api.salesbackend.service;

import com.zealep.api.salesbackend.model.entity.Venta;

import java.util.List;

public interface VentaService {

    Venta findById(Long id);

    List<Venta> findAll();

    Venta save(Venta v);

    void delete(Long id);

    boolean isExist(Long id);
}

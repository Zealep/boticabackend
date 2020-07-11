package com.zealep.api.salesbackend.service;

import com.zealep.api.salesbackend.model.entity.Compra;

import java.util.List;

public interface CompraService {

    Compra findById(Long id);

    List<Compra> findAll();

    Compra save(Compra c);

    void delete(Long id);

    boolean isExist(Long id);
}

package com.zealep.api.salesbackend.service;

import com.zealep.api.salesbackend.model.entity.Proveedor;

import java.util.List;

public interface ProveedorService {

    Proveedor findById(Long id);

    List<Proveedor> findAll();

    Proveedor save(Proveedor p);

    void delete(Long id);

    boolean isExist(Long id);
}

package com.zealep.api.salesbackend.service;


import com.zealep.api.salesbackend.model.entity.Producto;

import java.util.List;

public interface ProductoService {

    Producto findById(Long id);

    List<Producto> findAll();

    Producto save(Producto p);

    void delete(Long id);

    boolean isExist(Long id);

    void incrementStock(double stock,Long idProducto);

    void decrementStock(double stock,Long idProducto);

    boolean isExistCodigo(String codigo);
}

package com.zealep.api.salesbackend.service;


import com.zealep.api.salesbackend.model.entity.Categoria;

import java.util.List;

public interface CategoriaService {

    Categoria findById(Long id);

    List<Categoria> findAll();

    Categoria save(Categoria c);

    void delete(Long id);

    boolean isExist(Long id);


}

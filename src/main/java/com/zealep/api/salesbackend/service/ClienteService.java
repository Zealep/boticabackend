package com.zealep.api.salesbackend.service;

import com.zealep.api.salesbackend.model.entity.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente findById(Long id);

    List<Cliente> findAll();

    Cliente save(Cliente c);

    void delete(Long id);

    boolean isExist(Long id);
}

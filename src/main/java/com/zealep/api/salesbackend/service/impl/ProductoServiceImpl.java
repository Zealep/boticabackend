package com.zealep.api.salesbackend.service.impl;


import com.zealep.api.salesbackend.model.entity.Producto;
import com.zealep.api.salesbackend.repository.ProductoRepository;
import com.zealep.api.salesbackend.service.ProductoService;
import com.zealep.api.salesbackend.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productoService")
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return productoRepository.findAllActives(Constants.ACTIVE_STATE);
    }

    @Override
    @Transactional
    public Producto save(Producto p) {
        return productoRepository.save(p);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productoRepository.deleteLogic(id,Constants.INACTIVE_STATE);
    }

    @Override
    public boolean isExist(Long id) {
        return findById(id)!=null;
    }
}

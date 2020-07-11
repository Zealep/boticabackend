package com.zealep.api.salesbackend.service.impl;

import com.zealep.api.salesbackend.model.entity.Compra;
import com.zealep.api.salesbackend.repository.CompraRepository;
import com.zealep.api.salesbackend.service.CompraService;
import com.zealep.api.salesbackend.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("compraService")
public class CompraServiceImpl implements CompraService {

    @Autowired
    CompraRepository compraRepository;

    @Transactional(readOnly = true)
    @Override
    public Compra findById(Long id) {
        return compraRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Compra> findAll() {
        return compraRepository.findAllActives(Constants.ACTIVE_STATE);
    }

    @Transactional
    @Override
    public Compra save(Compra c) {
        c.setEstado(Constants.ACTIVE_STATE);
        c.getDetallesCompra().forEach(x -> x.setCompra(c));
        return compraRepository.save(c);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        compraRepository.deleteLogic(id,Constants.INACTIVE_STATE);
    }


    @Override
    public boolean isExist(Long id) {
        return findById(id)!=null;
    }
}

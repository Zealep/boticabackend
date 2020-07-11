package com.zealep.api.salesbackend.service.impl;

import com.zealep.api.salesbackend.model.entity.Proveedor;
import com.zealep.api.salesbackend.repository.ProveedorRepository;
import com.zealep.api.salesbackend.service.ProveedorService;
import com.zealep.api.salesbackend.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("proveedorService")
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    ProveedorRepository proveedorRepository;

    @Override
    @Transactional(readOnly = true)
    public Proveedor findById(Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Proveedor> findAll() {
        return proveedorRepository.findAllActives(Constants.ACTIVE_STATE);
    }

    @Override
    @Transactional
    public Proveedor save(Proveedor p) {
        p.setEstado(Constants.ACTIVE_STATE);
        return proveedorRepository.save(p);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        proveedorRepository.deleteLogic(id,Constants.INACTIVE_STATE);
    }

    @Override
    public boolean isExist(Long id) {
        return findById(id)!=null;
    }
}

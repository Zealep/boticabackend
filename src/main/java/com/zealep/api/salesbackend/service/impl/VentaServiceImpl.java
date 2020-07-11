package com.zealep.api.salesbackend.service.impl;

import com.zealep.api.salesbackend.model.entity.Venta;
import com.zealep.api.salesbackend.repository.VentaRepository;
import com.zealep.api.salesbackend.service.VentaService;
import com.zealep.api.salesbackend.service.VentaService;
import com.zealep.api.salesbackend.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ventaService")
public class VentaServiceImpl implements VentaService {

    @Autowired
    VentaRepository ventaRepository;

    @Transactional(readOnly = true)
    @Override
    public Venta findById(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Venta> findAll() {
        return ventaRepository.findAllActives(Constants.ACTIVE_STATE);
    }

    @Transactional
    @Override
    public Venta save(Venta v) {
        v.setEstado(Constants.ACTIVE_STATE);
        v.getDetallesVenta().forEach(x -> x.setVenta(v));
        return ventaRepository.save(v);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        ventaRepository.deleteLogic(id,Constants.INACTIVE_STATE);
    }
    
    
    @Override
    public boolean isExist(Long id) {
        return findById(id)!=null;
    }
}

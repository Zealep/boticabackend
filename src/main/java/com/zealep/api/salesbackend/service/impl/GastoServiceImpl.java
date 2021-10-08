package com.zealep.api.salesbackend.service.impl;


import com.zealep.api.salesbackend.model.entity.Gasto;
import com.zealep.api.salesbackend.repository.GastoRepository;
import com.zealep.api.salesbackend.service.GastoService;
import com.zealep.api.salesbackend.service.GastoService;
import com.zealep.api.salesbackend.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service("gastoService")
public class GastoServiceImpl implements GastoService {

    @Autowired
    GastoRepository gastoRepository;

    @Override
    @Transactional(readOnly = true)
    public Gasto findById(Long id) {
        return gastoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Gasto> findAll() {
        return gastoRepository.findAllActives(Constants.ACTIVE_STATE);
    }


    @Override
    @Transactional
    public Gasto save(Gasto g) {
        g.setEstado(Constants.ACTIVE_STATE);
        return gastoRepository.save(g);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        gastoRepository.deleteLogic(id, Constants.INACTIVE_STATE);
    }

    @Override
    public boolean isExist(Long id) {
        return findById(id) != null;
    }

    @Override
    public Double getTotalByMes() {
        return gastoRepository.findTotalMes(Constants.ACTIVE_STATE);
    }

    @Override
    public Double getTotalByDia(LocalDate date) {
        return gastoRepository.findTotalDia(date,Constants.ACTIVE_STATE);
    }
}

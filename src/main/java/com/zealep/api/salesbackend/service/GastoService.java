package com.zealep.api.salesbackend.service;


import com.zealep.api.salesbackend.model.entity.Gasto;

import java.time.LocalDate;
import java.util.List;

public interface GastoService {

    Gasto findById(Long id);

    List<Gasto> findAll();

    Gasto save(Gasto g);

    void delete(Long id);

    boolean isExist(Long id);

    Double getTotalByMes();

    Double getTotalByDia(LocalDate date);


}

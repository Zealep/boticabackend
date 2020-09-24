package com.zealep.api.salesbackend.service.impl;


import com.zealep.api.salesbackend.exception.BadRequestException;
import com.zealep.api.salesbackend.exception.NotFoundException;
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
        p.setEstado(Constants.ACTIVE_STATE);
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

    @Override
    public void incrementStock(double stock, Long idProducto) {

        Producto p = productoRepository.findById(idProducto).orElse(null);
        if (p == null){
            throw new NotFoundException("No existe el producto");
        }
        double stockToday = p.getStock();
        stockToday = stockToday + stock;
        
        productoRepository.updateStock(stockToday,p.getIdProducto());
    }

    @Override
    public void decrementStock(double stock, Long idProducto) {
        Producto p = productoRepository.findById(idProducto).orElse(null);
        if (p == null){
            throw new NotFoundException("No existe el producto");
        }
        double stockToday = p.getStock();
        if(stockToday < stock)
            throw new BadRequestException("No hay stock para el producto " + p.getCodigo() + "-" + p.getNombre());
        else
            stockToday = stockToday - stock;

        productoRepository.updateStock(stockToday,p.getIdProducto());
    }

    @Override
    public boolean isExistCodigo(String codigo) {
        Producto p = productoRepository.findByCodigo(codigo,Constants.ACTIVE_STATE);
        boolean exist=false;
        if(p!=null)
            exist = true;
        return exist;
    }
}

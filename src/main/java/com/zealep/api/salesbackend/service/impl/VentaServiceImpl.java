package com.zealep.api.salesbackend.service.impl;

import com.zealep.api.salesbackend.model.entity.DetalleVenta;
import com.zealep.api.salesbackend.model.entity.Venta;
import com.zealep.api.salesbackend.repository.DetalleVentaRepository;
import com.zealep.api.salesbackend.repository.VentaRepository;
import com.zealep.api.salesbackend.service.VentaService;
import com.zealep.api.salesbackend.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service("ventaService")
public class VentaServiceImpl implements VentaService {

    @Autowired
    VentaRepository ventaRepository;

    @Autowired
    ProductoServiceImpl productoService;

    @Autowired
    DetalleVentaRepository detalleVentaRepository;

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

    @Transactional(readOnly = true)
    @Override
    public List<Venta> findAnuladas() {
        return ventaRepository.findAllAnuladas(Constants.INACTIVE_STATE);
    }

    @Transactional
    @Override
    public Venta save(Venta v) {
        Integer codigo = this.obtenerUltimaVenta();
        v.setCodigo(String.valueOf(codigo));
        v.setEstado(Constants.ACTIVE_STATE);
        v.getDetallesVenta().forEach(x -> {
            x.setVenta(v);
            productoService.decrementStock(x.getCantidad(),x.getProducto().getIdProducto());
        });
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

    @Override
    public List<DetalleVenta> findDetails(Long id) {
        return detalleVentaRepository.findDetailsByVenta(id);
    }

    @Override
    public Double getTotalByMes() {
        return ventaRepository.findTotalMes(Constants.ACTIVE_STATE);
    }

    @Override
    public Double getTotalByDia(LocalDate date) {
        return ventaRepository.findTotalDia(date);
    }

    @Override
    public Integer obtenerUltimaVenta() {
        Integer last = ventaRepository.obtenerUltimaVenta();

        if(last == null)
            return 1 ;
         else return last + 1;
    }

    @Override
    public String formatCodigoVenta(String codigo) {
        if (codigo == null || codigo.equals("") || codigo.equals("null")){
            codigo = String.valueOf(this.obtenerUltimaVenta());
        }
        return Constants.PREFIX_VENTA + numeroCompletar(codigo,8);
    }

    public String numeroCompletar(String num, int length) {
        return Right("000000000000000000000000" + num, length);
    }

    public String Right(String text, int length) {
        return text.substring(text.length() - length, text.length());
    }
}

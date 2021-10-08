package com.zealep.api.salesbackend.repository;

import com.zealep.api.salesbackend.model.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto,Long> {


    @Query(value = "select p from Producto  p where p.estado=?1")
    List<Producto> findAllActives(String estado);

    @Modifying
    @Query(value = "update Producto p set p.estado=?2 where p.idProducto=?1")
    void deleteLogic(Long id,String estado);

    @Modifying
    @Query(value= "update Producto p set p.stock=?1 where p.idProducto=?2")
    void updateStock(double amount,Long idProducto);

    @Query(value = "select p from Producto p where p.codigo=?1 and p.estado=?2")
    Producto findByCodigo(String codigo,String estado);

    @Query(value = "select p from Producto  p where p.estado=?1 and p.stock <= p.stockMinimo")
    List<Producto> findAllStockMinimos(String estado);

    @Query(value = "select p from Producto  p where p.estado=?1 and p.stock = 0 ")
    List<Producto> findNoStock(String estado);

}

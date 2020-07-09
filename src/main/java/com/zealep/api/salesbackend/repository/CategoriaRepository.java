package com.zealep.api.salesbackend.repository;

import com.zealep.api.salesbackend.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {


    @Query(value = "select c from Categoria  c where c.estado=?1")
    List<Categoria> findAllActives(String estado);

    @Modifying
    @Query(value = "update Categoria c set c.estado=?2 where c.idCategoria=?1")
    void deleteLogic(Long id,String estado);
}

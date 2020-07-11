package com.zealep.api.salesbackend.repository;

import com.zealep.api.salesbackend.model.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {

    @Query(value = "select e from Empleado  e where e.estado=?1")
    List<Empleado> findAllActives(String estado);

    @Modifying
    @Query(value = "update Empleado e set e.estado=?2 where e.idEmpleado=?1")
    void deleteLogic(Long id,String estado);
}

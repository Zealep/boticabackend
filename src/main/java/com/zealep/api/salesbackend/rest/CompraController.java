package com.zealep.api.salesbackend.rest;

import com.zealep.api.salesbackend.exception.NotFoundException;
import com.zealep.api.salesbackend.model.entity.Compra;
import com.zealep.api.salesbackend.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/compra")
public class CompraController {

    @Autowired
    CompraService compraService;

    @GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Compra> buscarPorId(@PathVariable(value = "id") Long id) {
        if (!compraService.isExist(id))
            throw new NotFoundException("No existe el id " + id + " de la compra");
        return new ResponseEntity<Compra>(compraService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Compra>> bucarTodo() {
        return new ResponseEntity<List<Compra>>(compraService.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Compra> grabar(@RequestBody Compra compra) {
        return new ResponseEntity<Compra>(compraService.save(compra), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void borrar(@PathVariable(value = "id") Long id) {
        if (!compraService.isExist(id))
            throw new NotFoundException("No se encontro el id " + id + " de la compra");
        compraService.delete(id);
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Compra> modificar(@RequestBody Compra compra) {
        return new ResponseEntity<Compra>(compraService.save(compra), HttpStatus.OK);
    }


}

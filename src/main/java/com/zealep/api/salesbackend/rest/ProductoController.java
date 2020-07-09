package com.zealep.api.salesbackend.rest;


import com.zealep.api.salesbackend.exception.NotFoundException;
import com.zealep.api.salesbackend.model.entity.Producto;
import com.zealep.api.salesbackend.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> buscarPorId(@PathVariable(value = "id") Long id) {
        if (!productoService.isExist(id))
            throw new NotFoundException("No existe el id " + id + " del producto");
        return new ResponseEntity<Producto>(productoService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Producto>> bucarTodo() {
        return new ResponseEntity<List<Producto>>(productoService.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> grabar(@RequestBody Producto producto) {
        return new ResponseEntity<Producto>(productoService.save(producto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void borrar(@PathVariable(value = "id") Long id) {
        if (!productoService.isExist(id))
            throw new NotFoundException("No se encontro el id " + id + " del producto");
        productoService.delete(id);
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> modificar(@RequestBody Producto producto) {
        return new ResponseEntity<Producto>(productoService.save(producto), HttpStatus.OK);
    }
}

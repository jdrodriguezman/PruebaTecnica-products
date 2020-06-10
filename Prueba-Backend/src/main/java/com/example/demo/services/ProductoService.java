package com.example.demo.services;

import java.util.Optional;

import com.example.demo.model.Producto;

public interface ProductoService {

    Optional createService(Producto producto);

    Optional getByIdService(Integer id);

    Optional getAllService();

    Optional updateService(Producto producto);

    void deleteService(Integer id);
    
    Optional tobuy(Integer id, Integer cantidad);
 

}

package com.example.demo.repository.product.impl;

import java.util.Optional;

import com.example.demo.model.Producto;

public interface ProductoRepository {

    Optional<Producto> create(Producto producto);

    Optional<Producto> getById(Integer id);

    Optional<Iterable<Producto>> getAll();

    Optional<Producto> update(Producto producto);

    void delete(Integer id);

}

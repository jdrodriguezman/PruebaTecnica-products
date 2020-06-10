package com.example.demo.repository.product.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Producto;
import com.example.demo.repository.product.IProductoRepository;

import java.util.Optional;

@Component
public class ProductoRepositoryImpl implements ProductoRepository {

    @Autowired
    private IProductoRepository repository;

    @Override
    public Optional<Producto> create(Producto producto) {
        return Optional.of(repository.save(producto));
    }

    @Override
    public Optional<Producto> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Iterable<Producto>> getAll() {
        return Optional.of(repository.findAll());
    }

    @Override
    public Optional<Producto> update(Producto producto) {
        return Optional.of(repository.save(producto));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

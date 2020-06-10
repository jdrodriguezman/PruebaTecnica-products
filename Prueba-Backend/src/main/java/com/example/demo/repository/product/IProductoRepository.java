package com.example.demo.repository.product;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Producto;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface IProductoRepository extends CrudRepository<Producto, Integer> {

}

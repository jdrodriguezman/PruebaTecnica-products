package com.example.demo.controller;

import com.example.demo.model.Producto;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

public interface IProductoApi {
   ResponseEntity createProducto(Producto producto);

   ResponseEntity getProductById(Integer id);

   ResponseEntity getAllProducto();

   ResponseEntity updateProducto(Integer id, Producto producto);

   ResponseEntity deleteProducto(Integer id);
   
   Optional tobuyProduct(Integer id, Integer cantidad);
}

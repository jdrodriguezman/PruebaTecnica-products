package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Producto;
import com.example.demo.repository.product.impl.ProductoRepository;

@Service
public class ProductoServicesImpl implements ProductoService{
	
    @Autowired
    private ProductoRepository repository;

	@Override
	public Optional createService(Producto producto) {
		 return Optional.of(repository.create(producto));
	}

	@Override
	public Optional getByIdService(Integer id) {
		Optional<Producto> optional = repository.getById(id);
        if(optional.isPresent()){
            return optional;
        }else
            return Optional.empty();
	}


	@Override
	public Optional getAllService() {
		return Optional.of(repository.getAll());
	}


	@Override
	public Optional updateService(Producto producto) {
		Optional<Producto> optional = repository.getById(producto.getId());
        if(optional.isPresent()){
            return Optional.of(repository.update(producto));
        }else
            return Optional.empty();
	}


	@Override
	public void deleteService(Integer id) {
		repository.delete(id);
	}

	@Override
	public Optional tobuy(Integer id, Integer cantidad) {
		Optional<Producto> optional = repository.getById(id);
        if(optional.isPresent()){
        	Producto producto = optional.get();
        	if(cantidad <= producto.getStock()) {
        		int stockActual = producto.getStock() - cantidad;
        		producto.setStock(stockActual);
        		updateService(producto);
        		int valor = (cantidad * producto.getValorUnitario());
        		return Optional.of(valor);
        	}else {
        		return Optional.of("No Se Tiene Stock Suficiente");
        	}
        }else
            return Optional.empty();
	}



}

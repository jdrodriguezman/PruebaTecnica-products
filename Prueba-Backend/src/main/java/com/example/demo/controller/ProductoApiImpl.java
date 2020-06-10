package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.commons.constans.api.EndpointProductoApi;
import com.example.demo.commons.domains.response.builder.ResponseBuilder;
import com.example.demo.model.Producto;
import com.example.demo.services.ProductoService;


@RestController
@RequestMapping(value = EndpointProductoApi.PRODUCTO_API)
public class ProductoApiImpl implements IProductoApi{

	@Autowired
    private ProductoService productoService;	
	

	@Override
    @PostMapping(EndpointProductoApi.CREATE_PRODUCTO)
	public ResponseEntity createProducto( @RequestBody Producto producto) {
		return ResponseBuilder.newBuilder()
                .withStatus(HttpStatus.CREATED)
                .withResponse(productoService.createService(producto))
                .buildResponse();
	}

	@Override
    @GetMapping(EndpointProductoApi.GET_BY_ID_PRODUCTO)
	public ResponseEntity getProductById(@PathVariable("id") Integer id) {
		Optional<Producto> opt = productoService.getByIdService(id);
        return ResponseBuilder.newBuilder()
                .withStatus(opt.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .withResponse(opt.isPresent() ? opt.get() : null)
                .withMessage(opt.isPresent() ? null : "User not has been found")
                .buildResponse();
	}

	@Override
    @GetMapping(EndpointProductoApi.GET_ALL_PRODUCTO)
	public ResponseEntity getAllProducto() {
		return ResponseBuilder.newBuilder()
                .withStatus(HttpStatus.OK)
                .withResponse(productoService.getAllService())
                .buildResponse();
	}

	@Override
	@PutMapping(EndpointProductoApi.UPDATE_PRODUCTO)
	public ResponseEntity updateProducto(@PathVariable("id") Integer id, @RequestBody Producto producto) {
		producto.setId(id);
        Optional opt = productoService.updateService(producto);
        return ResponseBuilder.newBuilder()
                .withStatus(opt.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .withResponse(opt.isPresent() ? productoService.updateService(producto) : null)
                .withMessage(opt.isPresent() ? null : "Product not has been found")
                .buildResponse();
	}

	@Override
	@DeleteMapping(EndpointProductoApi.DELETE_PRODUCTO)
	public ResponseEntity deleteProducto(@PathVariable("id") Integer id) {
		productoService.deleteService(id);
        return ResponseBuilder.newBuilder()
                .withStatus(HttpStatus.OK)
                .withMessage("User has been deleted")
                .buildResponse();
	}

	@Override
    @GetMapping(EndpointProductoApi.TOBUY_PRODUCTO)
	public Optional tobuyProduct(@PathVariable("id") Integer id, @PathVariable("cantidad") Integer cantidad) {
		return productoService.tobuy(id, cantidad);
	}

	

}

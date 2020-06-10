package com.example.demo.commons.constans.api;

public interface EndpointProductoApi {
    String PRODUCTO_API = "/api/product/";
    String CREATE_PRODUCTO = "create/";
    String GET_BY_ID_PRODUCTO = "/{id}";
    String GET_ALL_PRODUCTO = "/";
    String UPDATE_PRODUCTO = "update/{id}";
    String DELETE_PRODUCTO = "delete/{id}";
    String TOBUY_PRODUCTO = "{id}/tobuy/{cantidad}";
}

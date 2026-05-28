package com.webflux.main.service;

import com.webflux.main.model.Producto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductosService {
	Flux<Producto> catalogo();
	Flux<Producto> productosPorCategoria(String categoria);
	Mono<Producto> buscarProducto(int codigo);
	Mono<Void> altaProducto(Producto producto);
	Mono<Producto> eliminarProducto(int codigo);
}

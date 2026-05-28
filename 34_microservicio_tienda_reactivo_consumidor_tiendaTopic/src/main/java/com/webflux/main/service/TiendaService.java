package com.webflux.main.service;

import com.webflux.main.model.Producto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TiendaService {
	Flux<Producto> catalogoPorStockMinimo(int stock);
	Mono<Producto> altaProducto(Producto producto);
}

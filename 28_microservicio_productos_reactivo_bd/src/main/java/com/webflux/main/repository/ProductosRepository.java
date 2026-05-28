package com.webflux.main.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.webflux.main.model.Producto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductosRepository extends ReactiveCrudRepository<Producto, Integer> {
	Flux<Producto> findByCategoria(String categoria);
	
	@Transactional
	@Query("delete from productos where nombre=?")
	Mono<Void> deleteNombre(String nombre);
}

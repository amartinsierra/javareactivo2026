package com.webflux.main.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.webflux.main.model.Producto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductosRepository extends ReactiveMongoRepository<Producto, Integer> {
	Flux<Producto> findByCategoria(String categoria);
	@Query("{'precioUnitario':{'$lt':?0}}")
	Flux<Producto> findPrecioMaximo(double precio);
}

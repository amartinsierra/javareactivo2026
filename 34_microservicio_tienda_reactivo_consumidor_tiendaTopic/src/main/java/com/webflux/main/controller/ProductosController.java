package com.webflux.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webflux.main.model.Producto;
import com.webflux.main.service.TiendaService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductosController {
	TiendaService productosService;

	public ProductosController(TiendaService productosService) {
		this.productosService = productosService;
	}
	@GetMapping(value="tienda",produces=MediaType.APPLICATION_NDJSON_VALUE)
	public Mono<ResponseEntity<Flux<Producto>>> productosStock(@RequestParam int stock){
		return Mono.just(productosService.catalogoPorStockMinimo(stock))
				.map(f->ResponseEntity.ok(f));
	}
	@PostMapping(value="tienda",consumes=MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<Mono<Void>>> alta(Producto producto){
		return productosService.altaProducto(producto) 
	            .flatMap(p -> Mono.just(
	                    ResponseEntity.ok(Mono.<Void>empty())  // o Mono<Void> que represente la operación
	            ))
	            .switchIfEmpty(
	                    Mono.just(ResponseEntity.status(HttpStatus.CONFLICT).body(Mono.empty()))
	            );
	}
}

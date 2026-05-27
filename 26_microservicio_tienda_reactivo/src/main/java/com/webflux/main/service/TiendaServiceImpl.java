package com.webflux.main.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.webflux.model.Producto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TiendaServiceImpl implements TiendaService {
	private String urlBase="http://localhost:8000/productos";
	@Override
	public Flux<Producto> catalogoPorStockMinimo(int stock) {
		return WebClient.create(urlBase)
				.get()
				.accept(MediaType.APPLICATION_NDJSON)
				.retrieve()
				.bodyToFlux(Producto.class)
				.filter(p->p.getStock() >= stock);
	}

	@Override
	public Mono<Producto> altaProducto(Producto producto) {
		return WebClient.create(urlBase)
				.post()
				.accept(MediaType.APPLICATION_NDJSON)
				.body(producto, getClass())
				.retrieve()
				.bodyToMono(Producto.class);
	}

}

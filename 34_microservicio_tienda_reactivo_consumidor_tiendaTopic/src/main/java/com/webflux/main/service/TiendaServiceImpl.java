package com.webflux.main.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.webflux.main.model.Producto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TiendaServiceImpl implements TiendaService {
	private String urlBase="http://localhost:8000/productos";
	@Value("${topico}")
	private String topico;
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
	@KafkaListener(topics = "${topico}",groupId = "grupo1")
	public void recibirProducto(Producto producto) {
		System.out.println("Producto recibido recien añadido: "+producto.getNombre());
	}

}

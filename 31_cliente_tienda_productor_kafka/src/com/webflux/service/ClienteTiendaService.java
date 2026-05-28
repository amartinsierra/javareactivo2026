package com.webflux.service;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.webflux.model.Elemento;

import reactor.core.publisher.Flux;

public class ClienteTiendaService {
	private String urlBase="http://localhost:9000/tienda";
	
	public Flux<Elemento> productosStockMin(int stock){
		return WebClient.create(urlBase+"?stock="+stock)
				.get()
				.accept(MediaType.APPLICATION_NDJSON)
				.retrieve()
				.bodyToFlux(Elemento.class);
	}
			
			
}

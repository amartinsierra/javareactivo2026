package com.javarx.service;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.javarx.model.Sensor;

import reactor.core.publisher.Flux;

public class SensoresService {
	private String url="http://localhost:8080/sensor/combi";
	public Flux<Sensor> infoSensores(){
		return WebClient.create(url)
				.get()
				.accept(MediaType.APPLICATION_NDJSON)
				.retrieve()
				.bodyToFlux(Sensor.class);
	}
}

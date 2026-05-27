package com.webflux.main.controller;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class ControladorBasico {
	@GetMapping(value="dias",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> dias(){
		return Flux.just("lunes","martes","miércoles","jueves")
				.delayElements(Duration.ofSeconds(1));
	}
	@GetMapping(value="valores",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Long> valores(){
		return Flux.interval(Duration.ofMillis(500));
	}
}

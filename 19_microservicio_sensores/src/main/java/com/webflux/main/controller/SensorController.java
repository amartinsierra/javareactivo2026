package com.webflux.main.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webflux.main.service.SensorService;

import reactor.core.publisher.Flux;

@RestController
public class SensorController {
	SensorService sensorService;

	public SensorController(SensorService sensorService) {
		super();
		this.sensorService = sensorService;
	}
	
	@GetMapping(value="sensor/temperatura",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Double> sensorTemperatura(){
		return sensorService.sensorTemperatura();
	}
}

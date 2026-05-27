package com.webflux.main.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webflux.main.model.Sensor;
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
	
	//otra entrada que devuelva los datos del sensor de humedad (20 y 80 %)
	@GetMapping(value="sensor/humedad",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Double> sensorHumedad(){
		return sensorService.sensorHumedad();
	}
	
	//otra entrada que devuelva un flujo con la combinación de ambos datos
	@GetMapping(value="sensor/combi",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Sensor> sensorCombinado(){
		return sensorService.sensorCombinado();
	}
	
}

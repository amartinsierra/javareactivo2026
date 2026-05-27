package com.webflux.main.service;

import com.webflux.main.model.Sensor;

import reactor.core.publisher.Flux;

public interface SensorService {
	Flux<Double> sensorTemperatura();
	Flux<Double> sensorHumedad();
	Flux<Sensor> sensorCombinado();
}

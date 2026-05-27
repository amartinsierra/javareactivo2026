package com.webflux.main.service;

import reactor.core.publisher.Flux;

public interface SensorService {
	Flux<Double> sensorTemperatura();
}

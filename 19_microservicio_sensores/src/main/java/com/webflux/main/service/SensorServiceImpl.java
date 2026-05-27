package com.webflux.main.service;

import java.time.Duration;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
@Service
public class SensorServiceImpl implements SensorService {

	@Override
	public Flux<Double> sensorTemperatura() {
		return Flux.interval(Duration.ofSeconds(1))
				.map(n->Math.random()*35+5);
	}

}

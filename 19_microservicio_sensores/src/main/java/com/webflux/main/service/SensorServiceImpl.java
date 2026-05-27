package com.webflux.main.service;

import java.time.Duration;

import org.springframework.stereotype.Service;

import com.webflux.main.model.Sensor;

import reactor.core.publisher.Flux;
@Service
public class SensorServiceImpl implements SensorService {

	@Override
	public Flux<Double> sensorTemperatura() {
		return Flux.interval(Duration.ofSeconds(1))
				.map(n->Math.random()*35+5);
	}

	@Override
	public Flux<Double> sensorHumedad() {
		return Flux.interval(Duration.ofSeconds(1))
				.map(n->Math.random()*60+20);
	}

	@Override
	public Flux<Sensor> sensorCombinado() {
		return Flux.zip(sensorTemperatura(), sensorHumedad(),(t,h)->new Sensor(t,h));
	}

}

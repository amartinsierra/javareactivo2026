package service;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class GeneradorSensor {
	private final Observable<Long> flujo=Observable.interval(500, TimeUnit.MILLISECONDS)
			.map(n->(long)(Math.random()*36+5))
			.share();
	
	public Observable<Long> datosTemperatura(){
		return flujo;
	}
}

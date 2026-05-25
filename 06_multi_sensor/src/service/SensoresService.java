package service;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import model.Sensor;

public class SensoresService {
	private Observable<Double> getTemperaturas(){
		return Observable.interval(300, TimeUnit.MILLISECONDS)
				.map(n->Math.random()*36+5);
	}
	private Observable<Integer> getHumedad(){
		return Observable.interval(300, TimeUnit.MILLISECONDS)
				.map(n->(int)(Math.random()*60+20));
	}
	public Observable<Sensor> getData(){
		return Observable.zip(
				getTemperaturas(),
				getHumedad(),
				(t,h)->new Sensor(t,h)
				);
	}
}

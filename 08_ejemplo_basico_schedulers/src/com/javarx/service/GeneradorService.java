package com.javarx.service;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
public class GeneradorService {
	public Observable<String> datos(){
		return Observable.just("lunes", "martes", "miércoles", "jueves");
	}
	
	public Observable<Long> numeros(){
		return Observable.interval(100, TimeUnit.MILLISECONDS);
	}
}

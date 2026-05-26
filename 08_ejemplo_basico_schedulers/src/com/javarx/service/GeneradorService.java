package com.javarx.service;

import java.util.concurrent.TimeUnit;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.core.Observable;
public class GeneradorService {
	public Observable<String> datos(){
		return Observable.just("lunes", "martes", "miércoles", "jueves")				
				.concatMap(s->Observable.just(s).delay(1,TimeUnit.SECONDS))	
				.subscribeOn(Schedulers.io())
				.map(s->{
					System.out.println("Procesando servidor: "+s+" en el hilo: "+Thread.currentThread().getName());
					return s.toUpperCase();
				});
	}
	
	
}

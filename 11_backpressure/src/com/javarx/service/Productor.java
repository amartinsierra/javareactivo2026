package com.javarx.service;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Flowable;

public class Productor {
	public Flowable<Long> flujo(){
		return Flowable.interval(10, TimeUnit.MILLISECONDS)
				.take(500)
				.map(d->{
					System.out.println("Produciendo: "+d);
					return d;
				})
				//.onBackpressureDrop(s->System.out.println("Descartando "+s));
				.onBackpressureLatest(s->System.out.println("Descartando "+s));
	}
}

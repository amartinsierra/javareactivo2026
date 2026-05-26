package com.javarx.client;

import com.javarx.service.Productor;

import io.reactivex.rxjava3.schedulers.Schedulers;

public class Cliente {

	public static void main(String[] args) throws InterruptedException {
		var productor=new Productor();
		productor.flujo()
		.observeOn(Schedulers.io())
		.subscribe(d->{
			System.out.println("Consumiendo: "+d);
			Thread.sleep(100);
		});
		
		Thread.sleep(20000);

	}

}

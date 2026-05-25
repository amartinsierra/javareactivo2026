package com.javarx.client;

import com.javarx.service.GeneradorService;

public class ConsumirCombinacion {

	public static void main(String[] args) throws InterruptedException {
		var generadorService=new GeneradorService();
		//generadorService.combinarMerge()
		//generadorService.combinarZip()
		generadorService.combinarLatest()
		.subscribe(System.out::println);

		Thread.sleep(6000);
	}

}

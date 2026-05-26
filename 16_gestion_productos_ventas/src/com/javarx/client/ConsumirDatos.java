package com.javarx.client;

import com.javarx.service.GeneradorDatosService;

import io.reactivex.rxjava3.schedulers.Schedulers;

public class ConsumirDatos {

	public static void main(String[] args) throws InterruptedException {
		var generadorDatos=new GeneradorDatosService();
		generadorDatos.getData()
		.observeOn(Schedulers.computation())
		.filter(d->d.getFacturacion()>300)
		.subscribe(d->System.out.println("Producto "+d.getCodigo()+" Facturado: "+d.getFacturacion()));

		Thread.sleep(15000);
	}

}

package com.javarx.cliente;

import com.javarx.service.GeneradorService;

import io.reactivex.rxjava3.schedulers.Schedulers;

public class MostrarDatos {

	public static void main(String[] args) throws InterruptedException {
		var generadorService=new GeneradorService();
		/*generadorService.datos()//Observable<String>
		.subscribe(s->System.out.println(s));*/
		
		generadorService.datos()
		.observeOn(Schedulers.io())
		.subscribe(s->System.out.println(s+" cliente: "+Thread.currentThread().getName()),
				t->System.out.println("Error!: "+t.getMessage()),
				()->System.out.println("Fin del flujo de datos!!!!"));
		
		for(int i=1;i<100;i++) {
			System.out.println("Haciendo cosas .... "+i+" en hilo "+Thread.currentThread().getName());
			Thread.sleep(50);
		}
		
		Thread.sleep(5000);
	}

}

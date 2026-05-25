package com.javarx.cliente;

import com.javarx.service.GeneradorService;

public class MostrarDatos {

	public static void main(String[] args) throws InterruptedException {
		var generadorService=new GeneradorService();
		/*generadorService.datos()//Observable<String>
		.subscribe(s->System.out.println(s));*/
		
		generadorService.numeros()
		.subscribe(System.out::println,
				t->System.out.println("Error!: "+t.getMessage()),
				()->System.out.println("Fin del flujo de datos!!!!"));
		
		for(int i=1;i<100;i++) {
			System.out.println("Haciendo cosas .... "+i);
			Thread.sleep(50);
		}
		
		Thread.sleep(5000);
	}

}

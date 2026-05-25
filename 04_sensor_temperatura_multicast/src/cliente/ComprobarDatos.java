package cliente;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import service.GeneradorSensor;

public class ComprobarDatos {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor=Executors.newCachedThreadPool();
		var generadorSensor=new GeneradorSensor();
		//hilo 1. Muestra los datos de temperatura
		executor.submit(()->generadorSensor.datosTemperatura().subscribe(t->System.out.println("hilo1 "+t)));
		//hilo 2. Muestra la media de temperatura recibida
		executor.submit(()->generadorSensor.datosTemperatura()
				//.collect(Collectors.averagingLong(t->t))
				.subscribe(t->System.out.println("media "+t)));
		
		
		Thread.sleep(10000);

	}

}

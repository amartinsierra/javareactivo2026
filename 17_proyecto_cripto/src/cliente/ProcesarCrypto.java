package cliente;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.schedulers.Schedulers;
import model.CryptoData;
import service.GeneradorCrypto;

public class ProcesarCrypto {
	public static void main(String[] args) throws InterruptedException {
		GeneradorCrypto service = new GeneradorCrypto();
		var limiteMax=66300;
		var limiteMin=66100;
        var flujo = service.flujoCotizacion();
        ExecutorService executor=Executors.newCachedThreadPool();
        executor.submit(()->
	        // Consumidor 1: alertas excesos
	        flujo
	        	.filter(p -> p.getNombre().equals("bitcoin")&&(p.getValor()>limiteMax||p.getValor()<limiteMin))
	            .observeOn(Schedulers.computation())
	            .subscribe(data -> 
	                 System.out.print("⚡ ALERTA de superación de límite!! "+data.getValor()))
        );
      
        /*executor.submit(()->{
	        // Consumidor 2: comparación BTC vs ETH
	        flujo
	        .buffer(2, TimeUnit.SECONDS) // cada 2 segundos recojo lo último de ambos
        }*/
        Thread.sleep(600000); // mantener vivo

	}
}

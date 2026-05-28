package cliente;

import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import io.reactivex.rxjava3.schedulers.Schedulers;
import service.GeneradorCrypto;

public class ProcesarCrypto {
	static KafkaProducer<String, Double> producer;
	static String topico="mediaTopic";	
	static {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("acks", "all");
		props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		producer=new KafkaProducer<>(props);
	}
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
      
        executor.submit(()->{
	        //envia a un tópico la cotización media de bitcoin en los últimos 5 minutos
        	flujo
        	.filter(p -> p.getNombre().equals("bitcoin"))
        	.buffer(5, TimeUnit.MINUTES)
        	.subscribe(d->producer.send(new ProducerRecord<String,Double>(topico,d.stream()
        			.mapToDouble(c->c.getValor())
        			.average()
        			.getAsDouble())));
        });
        Thread.sleep(600000); // mantener vivo

	}
}

package com.webflux.client;

import java.util.Properties;
import java.util.Scanner;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.webflux.service.ClienteTiendaService;

public class MostrarInfo {
	static KafkaProducer<String, String> producer;
	static String topico="productosTopic";	
	static {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("acks", "all");
		props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		producer=new KafkaProducer<>(props);
	}
	public static void main(String[] args) throws InterruptedException {
		Scanner scan=new Scanner(System.in);
		ClienteTiendaService consultaService=new ClienteTiendaService();
		System.out.println("Introduce stock mínimo:");
		int stockMin=scan.nextInt();
		consultaService.productosStockMin(stockMin)
		.subscribe(it->enviarInfo("Producto: "+it.getNombre()+" Stock: "+it.getStock()+" Categoria: "+it.getCategoria()));
		
		Thread.sleep(10000);

	}
	private static void enviarInfo(String info) {
		System.out.println(info);
		var producerRecord=new ProducerRecord<String, String>(topico, info);
		producer.send(producerRecord);
	}

}

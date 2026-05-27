package com.webflux.client;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class ClienteDias {

	public static void main(String[] args) throws InterruptedException {
		String url="http://localhost:8080/dias";
		WebClient webClient=WebClient.create(url);
		webClient
		.get()
		.accept(MediaType.TEXT_EVENT_STREAM)
		.retrieve() //ResponseSpec
		.bodyToFlux(String.class)
		.subscribe(System.out::println);
		
		Thread.sleep(10000);
	}

}

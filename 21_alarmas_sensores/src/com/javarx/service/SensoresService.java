package com.javarx.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarx.model.Sensor;

import io.reactivex.rxjava3.core.Observable;

public class SensoresService {
	private String url="http://localhost:8080/sensor/combi";
	public Observable<Sensor> infoSensores(){
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		        .uri(URI.create(url))
		        .GET()
		        .build();
		ObjectMapper mapper=new ObjectMapper();
		CompletableFuture<HttpResponse<Stream<String>>> respuesta=
				client.sendAsync(request, HttpResponse.BodyHandlers.ofLines());
		return Observable.fromFuture(respuesta)
				.flatMap(resp->Observable.fromStream(resp.body())) //Observable<String>
				.map(s->mapper.readValue(s,Sensor.class));
	}
}

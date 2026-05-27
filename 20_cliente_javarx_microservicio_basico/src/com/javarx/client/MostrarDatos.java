package com.javarx.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import io.reactivex.rxjava3.core.Observable;

public class MostrarDatos {

	public static void main(String[] args) {
		String url="http://localhost:8080/dias";
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		        .uri(URI.create(url))
		        .GET()
		        .build();

		CompletableFuture<HttpResponse<Stream<String>>> respuesta=
				client.sendAsync(request, HttpResponse.BodyHandlers.ofLines());
		Observable<String> observable=Observable.fromFuture(respuesta)
				.flatMap(resp->Observable.fromStream(resp.body()));//Observable<String>
		observable.subscribe(System.out::println);
		
	}

}

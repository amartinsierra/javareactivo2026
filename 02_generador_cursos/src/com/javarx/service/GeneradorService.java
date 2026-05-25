package com.javarx.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

import com.javarx.model.Curso;

public class GeneradorService {
	private final List<Curso> cursos = List.of(
	           new Curso("Java Básico", 20),
	           new Curso("Spring Boot", 40),
	           new Curso("Microservicios", 50),
	           new Curso("RxJava", 15),
	           new Curso("Docker", 30),
	           new Curso("Kubernetes", 45)
	  );
	public Observable<Curso> catalogo(){
		return Observable.fromIterable(cursos)
				.concatMap(c->Observable.just(c).delay(300, TimeUnit.MILLISECONDS));//incluye retardo entre cada elemento
	}
}

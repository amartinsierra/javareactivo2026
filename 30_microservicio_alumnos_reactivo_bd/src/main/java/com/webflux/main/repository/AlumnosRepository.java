package com.webflux.main.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.webflux.main.model.Alumno;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AlumnosRepository extends ReactiveCrudRepository<Alumno, Integer> {
	Flux<Alumno> findByCurso(String curso);
	
	Mono<Alumno> findFirstByNombreAndCurso(String nombre, String curso);
	
	
}

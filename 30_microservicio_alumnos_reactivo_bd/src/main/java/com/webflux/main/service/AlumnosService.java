package com.webflux.main.service;

import com.webflux.main.model.Alumno;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AlumnosService {

	Flux<Alumno> alumnosPorCurso(String curso);
	
	Mono<Alumno> altaAlumno(Alumno alumno);
	
}

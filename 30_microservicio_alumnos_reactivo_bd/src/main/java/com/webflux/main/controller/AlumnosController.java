package com.webflux.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webflux.main.model.Alumno;
import com.webflux.main.service.AlumnosService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class AlumnosController {
	AlumnosService alumnosService;

	public AlumnosController(AlumnosService alumnosService) {
		this.alumnosService = alumnosService;
	}
	
	@GetMapping(value="alumnos", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Flux<Alumno>> buscarPorCurso(@RequestParam String curso){
		return ResponseEntity.ok(alumnosService.alumnosPorCurso(curso));
	}
	
	@PostMapping(value="alumnos", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<Alumno>> alta(@RequestBody Alumno alumno){
		alumno.setNuevo(true);
		return alumnosService.altaAlumno(alumno)
				.map(a -> new ResponseEntity<>(a, HttpStatus.CREATED))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.CONFLICT));
	}
	
}

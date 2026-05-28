package com.webflux.main.service;

import org.springframework.stereotype.Service;

import com.webflux.main.model.Alumno;
import com.webflux.main.repository.AlumnosRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class AlumnosServiceImpl implements AlumnosService {
	
	AlumnosRepository alumnosRepository;

	public AlumnosServiceImpl(AlumnosRepository alumnosRepository) {
		this.alumnosRepository = alumnosRepository;
	}

	@Override
	public Flux<Alumno> alumnosPorCurso(String curso) {
		return alumnosRepository.findByCurso(curso);
	}

	@Override
	public Mono<Alumno> altaAlumno(Alumno alumno) {
		return alumnosRepository.findFirstByNombreAndCurso(alumno.getNombre(), alumno.getCurso())
				.switchIfEmpty(Mono.just(alumno)
						.flatMap(p->alumnosRepository.save(p)));//Mono<Alumno>
	}

}

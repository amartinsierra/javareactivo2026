package service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import model.Posicion;

public class GpsService {
	Flowable<Posicion> posicion;
	// Flujo de posiciones (latitud/longitud)

	Flowable<double[]> coordenadas= Flowable.interval(10, TimeUnit.MILLISECONDS)
			.map(tick -> new double[]{
					40.0 + Math.random()*30,   // latitud
					-3.5 + Math.random()*30    // longitud
			})
			.onBackpressureLatest();


	// Flujo de tiempos

	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
	Flowable<String> tiempos= Flowable.interval(10, TimeUnit.MILLISECONDS)
			.map(tick -> LocalDateTime.now().format(fmt))
			.onBackpressureLatest();
	{
		posicion=Flowable.combineLatest(
				coordenadas,
				tiempos,
				(coords, tiempo) -> new Posicion(coords[0], coords[1], tiempo))
				.share();

	}

	// Fusionamos ambos flujos en Posicion
	public Flowable<Posicion> generarPosicionesCompletas() {
		return posicion;

	}
}

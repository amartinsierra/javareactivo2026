package service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import model.Posicion;

public class GpsService {
	Observable<Posicion> posicion;
	// Flujo de posiciones (latitud/longitud)

	Observable<double[]> coordenadas= Observable.interval(2, TimeUnit.SECONDS)
			.map(tick -> new double[]{
					40.0 + Math.random()*30,   // latitud
					-3.5 + Math.random()*30    // longitud
			});


	// Flujo de tiempos

	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
	Observable<String> tiempos= Observable.interval(1, TimeUnit.SECONDS)
			.map(tick -> LocalDateTime.now().format(fmt));
	{
		posicion=Observable.combineLatest(
				coordenadas,
				tiempos,
				(coords, tiempo) -> new Posicion(coords[0], coords[1], tiempo))
				.share();

	}

	// Fusionamos ambos flujos en Posicion
	public Observable<Posicion> generarPosicionesCompletas() {
		return posicion;

	}
}

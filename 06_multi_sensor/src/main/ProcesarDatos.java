package main;

import service.SensoresService;

public class ProcesarDatos {

	public static void main(String[] args) throws InterruptedException {
		
		var sensores=new SensoresService();
		sensores
		.getData()
		.subscribe(d-> {
			System.out.println("Temperatura: "+d.getTemperatura()+" Humedad: "+d.getHumedad());
			if (d.getTemperatura() < 10 || d.getTemperatura() > 35) {
				System.out.println("¡ALERTA TEMPERATURA! Valor: " + d.getTemperatura());
			}
			if (d.getHumedad() < 30 || d.getHumedad() > 70) {
				System.out.println("¡ALERTA HUMEDAD! Valor: " + d.getHumedad());
			}
		});
		Thread.sleep(10000);

	}

}

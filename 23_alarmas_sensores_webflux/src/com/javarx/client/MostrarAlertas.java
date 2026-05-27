package com.javarx.client;

import com.javarx.service.SensoresService;

public class MostrarAlertas {

	public static void main(String[] args) throws InterruptedException {
		var sensoresService=new SensoresService();
		sensoresService.infoSensores()
		.filter(s->(s.getTemperatura()>37||s.getTemperatura()<10)||(s.getHumedad()<30||s.getHumedad()>70))
		.subscribe(s->System.out.println("Alerta: "+s.getHumedad()+" - "+s.getTemperatura()));

		Thread.sleep(15000);
	}

}

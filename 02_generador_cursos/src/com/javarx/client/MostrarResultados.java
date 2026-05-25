package com.javarx.client;

import java.util.Scanner;

import com.javarx.service.GeneradorService;

public class MostrarResultados {

	public static void main(String[] args) throws InterruptedException {
		var generadorService=new GeneradorService();
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce la duración máxima: ");
		int duracion=sc.nextInt();
		generadorService.catalogo()
		.filter(c->c.getDuracion()<=duracion)
		.subscribe(c->System.out.println(c.getNombre()));
		Thread.sleep(5000);
				

	}

}

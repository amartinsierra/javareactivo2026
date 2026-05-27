package com.webflux.client;

import java.util.Scanner;

import com.webflux.service.ClienteTiendaService;

import reactor.core.scheduler.Schedulers;

public class MostrarInfo {

	public static void main(String[] args) throws InterruptedException {
		Scanner scan=new Scanner(System.in);
		ClienteTiendaService consultaService=new ClienteTiendaService();
		System.out.println("Introduce stock mínimo:");
		int stockMin=scan.nextInt();
		consultaService.productosStockMin(stockMin)
		.subscribe(it->System.out.println("Producto: "+it.getNombre()+" Stock: "+it.getStock()+" Categoria: "+it.getCategoria()));
		
		Thread.sleep(10000);

	}

}

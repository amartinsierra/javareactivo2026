package com.webflux.main.service;

import org.springframework.stereotype.Service;

import com.webflux.main.model.Producto;
import com.webflux.main.repository.ProductosRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class ProductosServiceImpl implements ProductosService {
	
	ProductosRepository productosRepository;

	public ProductosServiceImpl(ProductosRepository productosRepository) {
		this.productosRepository = productosRepository;
	}

	@Override
	public Flux<Producto> catalogo() {
		return productosRepository.findAll();
	}

	@Override
	public Flux<Producto> productosPorCategoria(String categoria) {
		return productosRepository.findByCategoria(categoria);
	}

	@Override
	public Mono<Producto> buscarProducto(int codigo) {
		return productosRepository.findById(codigo)
				.switchIfEmpty(Mono.just(new Producto()));
	}

	@Override
	public Mono<Void> altaProducto(Producto producto) {
		return productosRepository.findById(producto.getCodProducto())//Mono<Producto>
				.switchIfEmpty(Mono.just(producto)
						.flatMap(p->productosRepository.save(p)))//Mono<Producto>
				.then();//Mono<Void>
	}

	@Override
	public Mono<Producto> eliminarProducto(int codigo) {
		return productosRepository.findById(codigo) //Mono<Producto>
				.flatMap(p->productosRepository.deleteById(codigo) //Mono<Void>
						.then(Mono.just(p))//Mono<Producto>
				);//Mono<Producto>
	}
	

}

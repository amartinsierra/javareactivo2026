package com.webflux.model;

public class Elemento {
	private int codProducto;
	private String nombre;
	private String categoria;
	private double precioUnitario;
	private int stock;
	public Elemento(int codProducto, String nombre, String categoria, double precioUnitario, int stock) {
		super();
		this.codProducto = codProducto;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precioUnitario = precioUnitario;
		this.stock = stock;
	}
	public Elemento() {
		super();
	}
	public int getCodProducto() {
		return codProducto;
	}
	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}

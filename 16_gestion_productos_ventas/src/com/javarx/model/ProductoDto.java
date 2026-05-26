package com.javarx.model;

public class ProductoDto {
	private int codigo;
	private double precio;
	private int stock;
	public ProductoDto(int codigo, double precio, int stock) {
		super();
		this.codigo = codigo;
		this.precio = precio;
		this.stock = stock;
	}
	
	public ProductoDto() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
}

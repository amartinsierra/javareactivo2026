package com.javarx.model;

public class DatosFlujoDto {
	private int codigo;
	private double precio;
	private double facturacion;
	public DatosFlujoDto(int codigo, double precio, double facturacion) {
		super();
		this.codigo = codigo;
		this.precio = precio;
		this.facturacion = facturacion;
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
	public double getFacturacion() {
		return facturacion;
	}
	public void setFacturacion(double facturacion) {
		this.facturacion = facturacion;
	}
	
}

package com.javarx.model;

public class VentaDto {
	private int codigo;
	private double facturacion;
	public VentaDto(int codigo, double facturacion) {
		super();
		this.codigo = codigo;
		this.facturacion = facturacion;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getFacturacion() {
		return facturacion;
	}
	public void setFacturacion(double facturacion) {
		this.facturacion = facturacion;
	}
	
}

package com.javarx.model;

public class Sensor {
	private double temperatura;
	private double humedad;
	public Sensor(double temperatura, double humedad) {
		super();
		this.temperatura = temperatura;
		this.humedad = humedad;
	}
	public Sensor() {
		super();
	}
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	public double getHumedad() {
		return humedad;
	}
	public void setHumedad(double humedad) {
		this.humedad = humedad;
	}
}

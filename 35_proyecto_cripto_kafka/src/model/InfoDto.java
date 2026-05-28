package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class InfoDto {
	private double eur;

	public InfoDto(double eur) {
		this.eur = eur;
	}
	public InfoDto() {

	}
	public double getEur() {
		return eur;
	}
	public void setEur(double eur) {
		this.eur = eur;
	}
	
	
}

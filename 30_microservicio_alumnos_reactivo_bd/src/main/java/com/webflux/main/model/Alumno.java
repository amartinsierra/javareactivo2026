package com.webflux.main.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table("alumnoscursos")
public class Alumno implements Persistable<Integer>{
	@Id
	@Column("idAlumno")
	private int idAlumno;
	private String nombre;
	private String curso;
	private String email;
	private double nota;
	
	@Transient
	private boolean nuevo;
	@JsonIgnore
	@Override
	public Integer getId() {
		return idAlumno;
	}
	@JsonIgnore
	@Override
	public boolean isNew() {
		return nuevo;
	}
	public Alumno(int idAlumno, String nombre, String curso, String email, double nota) {
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.curso = curso;
		this.email = email;
		this.nota = nota;
	}
	public Alumno() {
	}
	public int getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public boolean isNuevo() {
		return nuevo;
	}
	public void setNuevo(boolean nuevo) {
		this.nuevo = nuevo;
	}
	
	
}

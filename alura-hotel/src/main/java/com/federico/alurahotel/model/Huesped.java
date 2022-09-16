package com.federico.alurahotel.model;

import java.sql.Date;
import java.time.LocalDate;

public class Huesped {
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String nacionalidad;
	private String telefono;  //check tipo de dato en la db
	private int idReservas;
	
	public Huesped(String nombre, String apellido, LocalDate fechaNacimiento, 
			String nacionalidad, String telefono, int idReservas) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = Date.valueOf(fechaNacimiento);
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idReservas = idReservas;
	}
	
	public Huesped(String nombre, String apellido, LocalDate fechaNacimiento, 
			String nacionalidad, int idReservas) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = Date.valueOf(fechaNacimiento);
		this.nacionalidad = nacionalidad;
		this.idReservas = idReservas;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public int getIdReservas() {
		return idReservas;
	}
	
}

package com.federico.alurahotel.model;

import java.sql.Date;
import java.time.LocalDate;

public class Reserva {
	private Date fechaEntrada;
	private Date fechaSalida;
	private Double reservationValue;
	private int reservationId;
	private String formaDePago;
	
	
	public Reserva() {
		
	}
	

	public Reserva(LocalDate fechaEntrada, LocalDate fechaSalida, Double reservationValue) {
		this.fechaEntrada = Date.valueOf(fechaEntrada);
		this.fechaSalida = Date.valueOf(fechaSalida);
		this.reservationValue = reservationValue;
	}
	
	public Reserva(Date fechaEntrada, Date fechaSalida, Double reservationValue) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.reservationValue = reservationValue;
	}
	
	
	
	public Date getFechaEntrada() {
		return fechaEntrada;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public Double getReservationValue() {
		return reservationValue;
	}
	
	public int getReservationId() {
		return this.reservationId;
	}
	
	public String getFormaDePago() {
		return formaDePago;
	}
	
	
	
	
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}
}

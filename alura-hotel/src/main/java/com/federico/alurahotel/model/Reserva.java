package com.federico.alurahotel.model;

import java.time.LocalDate;

public class Reserva {
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	private Double reservationValue;
	private int reservationId;
	
	public Reserva(LocalDate fechaEntrada, LocalDate fechaSalida, Double reservationValue) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.reservationValue = reservationValue;
	}
	
	
	
	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}
	public LocalDate getFechaSalida() {
		return fechaSalida;
	}
	public Double getReservationValue() {
		return reservationValue;
	}
	
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
}

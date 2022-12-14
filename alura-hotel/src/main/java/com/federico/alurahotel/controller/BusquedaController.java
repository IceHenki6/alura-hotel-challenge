package com.federico.alurahotel.controller;

import java.util.List;

import com.federico.alurahotel.dao.BusquedaDao;
import com.federico.alurahotel.factory.ConnectionFactory;
import com.federico.alurahotel.model.Huesped;
import com.federico.alurahotel.model.Reserva;

public class BusquedaController {
	private BusquedaDao busquedaDao;
	
	public BusquedaController(){
		var connectionFactory = new ConnectionFactory();
		this.busquedaDao = new BusquedaDao(connectionFactory.createConnection());
	}
	
	public Reserva searchByIdReservation(String idStr) {
		
		int id = Integer.parseInt(idStr);
		return busquedaDao.searchByReservationId(id);
		
	}
	
	public List<Reserva> listReservations(){
		return busquedaDao.listReservations();
	}
	
	public List<Huesped> listGuests(){
		return busquedaDao.listGuests();
	}
	
	public List<Huesped> searchByLastName(String lastName){
		return busquedaDao.searchByLastName(lastName);
	}
	
	public Huesped searchByHuespedResId(int id) {
		return busquedaDao.searchHuespedByResId(id);
	}
	
	public void EditReservations(Reserva reserva) {
		busquedaDao.editReservation(reserva);
	}
	
	public void EditGuest(Huesped huesped) {
		busquedaDao.editGuest(huesped);
	}
	
	public void deleteGuest(int id) {
		busquedaDao.deleteGuest(id);
	}
	
	public void deleteReservation(int id) {
		busquedaDao.deleteReservation(id);
	}
}

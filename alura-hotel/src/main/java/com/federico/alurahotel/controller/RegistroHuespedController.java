package com.federico.alurahotel.controller;

import com.federico.alurahotel.dao.RegistroHuespedDao;
import com.federico.alurahotel.factory.ConnectionFactory;
import com.federico.alurahotel.model.Huesped;

public class RegistroHuespedController {
	private RegistroHuespedDao registroHuespedDao;
	
	public RegistroHuespedController() {
		var factory = new ConnectionFactory();
		this.registroHuespedDao = new RegistroHuespedDao(factory.createConnection());
	}
	
	public void registrarHuesped(Huesped guest) {
		registroHuespedDao.registerGuest(guest);
	}
}

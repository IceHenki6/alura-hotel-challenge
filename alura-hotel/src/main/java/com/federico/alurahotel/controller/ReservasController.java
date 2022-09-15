package com.federico.alurahotel.controller;

import com.federico.alurahotel.dao.ReservasDao;
import com.federico.alurahotel.factory.ConnectionFactory;
import com.federico.alurahotel.utils.Money;

public class ReservasController {
	private ReservasDao reservasDao;
	
	public ReservasController() {
		var factory = new ConnectionFactory();
		this.reservasDao = new ReservasDao(factory.createConnection());
	}
	
	public Integer obtainId() {
		return reservasDao.obtainReservationId();
	}
	
	public static double obtainReservationValue(int days) {
		return Money.Round(days* 100.559, 2);
	}
}

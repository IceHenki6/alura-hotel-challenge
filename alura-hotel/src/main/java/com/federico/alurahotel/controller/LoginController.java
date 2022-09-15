package com.federico.alurahotel.controller;

import com.federico.alurahotel.dao.LoginDao;
import com.federico.alurahotel.factory.ConnectionFactory;

public class LoginController {
	private LoginDao loginDao;
	
	public LoginController() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		this.loginDao = new LoginDao(connectionFactory.createConnection());
	}
	
	public boolean validateUser(String user, String password) {
		return loginDao.validateUser(user, password);
	}
}

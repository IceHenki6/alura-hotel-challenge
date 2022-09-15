package com.federico.alurahotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.federico.alurahotel.model.User;

public class LoginDao {
	private Connection con;
	private User usuario;
	
	public LoginDao(Connection con) {
		this.con = con;
	}
	

	
	public boolean validateUser(String usuario, String password) {
		boolean userValidated = false;
		String retrievedUsername = "";
		String retrievedUserPassword = "";
		try {
			try(PreparedStatement statement = con.prepareStatement
					("SELECT user_name, user_password FROM usuario "
							+ "WHERE user_name = ? AND user_password = ?");){
				
				statement.setString(1,usuario);
				statement.setString(2, password);
				
				statement.execute();

				
				try(ResultSet resultSet = statement.getResultSet();){
					while(resultSet.next()) {
//						this.usuario = new User(resultSet.getString(1), resultSet.getString(2));
						retrievedUsername = resultSet.getString(1);
						retrievedUserPassword = resultSet.getString(2);
					}
					
					if(retrievedUsername.contains(usuario) && retrievedUserPassword.contains(password)) {
						userValidated = true;
					}
				}catch(SQLException e) {
					new RuntimeException(e);
				}
			}
		}catch(SQLException e) {
			new RuntimeException(e);
		}
		
		return userValidated;
	}
}

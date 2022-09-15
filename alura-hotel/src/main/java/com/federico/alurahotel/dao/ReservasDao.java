package com.federico.alurahotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservasDao {
	private Connection con;
	public ReservasDao(Connection con) {
		this.con = con;
	}
	
	
	
	public Integer obtainReservationId() {
		Integer reservationId = null;
		try {
			final PreparedStatement statement = con.prepareStatement
					("SELECT id FROM reservas ORDER BY id DESC "+
							"LIMIT 1");
			try(statement){
				ResultSet resultSet = statement.executeQuery();
				
				try(resultSet){
					while(resultSet.next()) {
						reservationId = resultSet.getInt(1);
					}
				}
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return reservationId + 1;
	}
	
}

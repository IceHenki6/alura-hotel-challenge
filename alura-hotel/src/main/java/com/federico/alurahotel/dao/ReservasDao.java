package com.federico.alurahotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.federico.alurahotel.model.Reserva;

public class ReservasDao {
	private Connection con;
	public ReservasDao(Connection con) {
		this.con = con;
	}
	
	public void registerReservation(Reserva reserva) {
		try {
			final PreparedStatement statement = con.prepareStatement("INSERT INTO reservas " 
					+ "(fecha_entrada, fecha_salida, valor, forma_de_pago)"
					+ " VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			
			try(statement){
				statement.setDate(1,reserva.getFechaEntrada());
				statement.setDate(2, reserva.getFechaSalida());
				statement.setDouble(3, reserva.getReservationValue());
				statement.setString(4, reserva.getFormaDePago());
				
				statement.execute();
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
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

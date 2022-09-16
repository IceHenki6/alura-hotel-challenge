package com.federico.alurahotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.federico.alurahotel.model.Huesped;

public class RegistroHuespedDao {
	private Connection con;
	
	public RegistroHuespedDao(Connection con) {
		this.con = con;
	}
	
	public void registerGuest(Huesped guest) {
		try {
			String sql = "INSERT INTO huespedes " 
					+ "(nombre,apellido,fecha_de_nacimiento,nacionalidad,telefono, id_reservas) "
					+ "VALUES(?,?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			try(statement){
				statement.setString(1, guest.getNombre());
				statement.setString(2, guest.getApellido());
				statement.setDate(3, guest.getFechaNacimiento());
				statement.setString(4, guest.getNacionalidad());
				statement.setString(5, guest.getTelefono());
				statement.setInt(6, guest.getIdReservas());
				
				statement.execute();
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}

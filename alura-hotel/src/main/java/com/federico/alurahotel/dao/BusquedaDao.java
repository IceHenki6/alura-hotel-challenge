package com.federico.alurahotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.federico.alurahotel.model.Huesped;
import com.federico.alurahotel.model.Reserva;

public class BusquedaDao {
	
	private Connection con;
	
	public BusquedaDao(Connection con) {
		this.con = con;
	}
	
	public Reserva searchByReservationId(int id) {
		Reserva reserva = new Reserva();
		try {
			String sql = "SELECT id, fecha_entrada, fecha_salida, valor, forma_de_pago FROM reservas WHERE ID = ?";
			final PreparedStatement preparedStatement = con.prepareStatement(sql);
			try(preparedStatement){
				preparedStatement.setInt(1, id);
				final ResultSet resultSet = preparedStatement.executeQuery();
				
				try(resultSet){
					while(resultSet.next()) {
						reserva = new Reserva(
								resultSet.getDate("fecha_entrada"),
								resultSet.getDate("fecha_salida"),
								resultSet.getDouble("valor")
							);
						reserva.setReservationId(resultSet.getInt("id"));
						reserva.setFormaDePago(resultSet.getString("forma_de_pago"));
						
					}
				}
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return reserva;
	}
	
	
	public List<Huesped> searchByLastName(String lastName){
		List<Huesped> resultado = new ArrayList<>();
		try {
			String sql = "SELECT id, nombre, apellido, fecha_de_nacimiento, nacionalidad, telefono, id_reservas FROM huespedes"
					+ " WHERE apellido ~* ?";
			final PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			try(preparedStatement){
				String regex = lastName;
				preparedStatement.setString(1, regex);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				try(resultSet){
					while(resultSet.next()) {
						Huesped huesped = new Huesped(
								resultSet.getInt("id"),
								resultSet.getString("nombre"),
								resultSet.getString("apellido"),
								resultSet.getDate("fecha_de_nacimiento"),
								resultSet.getString("nacionalidad"),
								resultSet.getString("telefono"),
								resultSet.getInt("id_reservas")
							);
						resultado.add(huesped);
					}
				}
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return resultado;
	}
	
	
	public Huesped searchHuespedByResId(int id) {
		Huesped huesped = new Huesped();
		try {
			String sql = "SELECT id, nombre, apellido, fecha_de_nacimiento, nacionalidad, telefono, id_reservas" 
					+ " FROM huespedes WHERE id_reservas = ?";
			final PreparedStatement statement = con.prepareStatement(sql);
			try(statement){
				statement.setInt(1, id);
				
				ResultSet resultSet = statement.executeQuery();
				try(resultSet){
					while(resultSet.next()) {
						huesped = new Huesped(
								resultSet.getInt("id"),
								resultSet.getString("nombre"),
								resultSet.getString("apellido"),
								resultSet.getDate("fecha_de_nacimiento"),
								resultSet.getString("nacionalidad"),
								resultSet.getString("telefono"),
								resultSet.getInt("id_reservas")
							);
					}
				}
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return huesped;
	}
	
	
	public void editReservation(Reserva reserva) {
		
		try {
			String sql = "UPDATE reservas SET " 
					+ "fecha_entrada = ?, "
					+ "fecha_salida = ?, "
					+ "valor = ?, "
					+ "forma_de_pago = ? "
					+ "WHERE ID = ?";
			final PreparedStatement statement = con.prepareStatement(sql);
			try(statement){
				statement.setDate(1, reserva.getFechaEntrada());
				statement.setDate(2, reserva.getFechaSalida());
				statement.setDouble(3, reserva.getReservationValue());
				statement.setString(4, reserva.getFormaDePago());
				statement.setInt(5, reserva.getReservationId());
				
				statement.execute();
			}
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void editGuest(Huesped guest) {
		try {
			String sql = "UPDATE huespedes SET "
					+ "nombre = ?, "
					+ "apellido = ?, "
					+ "fecha_de_nacimiento = ?, "
					+ "nacionalidad = ?, "
					+ "telefono = ? "
					+ "WHERE id = ?";
			final PreparedStatement statement = con.prepareStatement(sql);
			try(statement){
				statement.setString(1, guest.getNombre());
				statement.setString(2, guest.getApellido());
				statement.setDate(3, guest.getFechaNacimiento());
				statement.setString(4, guest.getNacionalidad());			
				statement.setString(5, guest.getTelefono());
				statement.setInt(6, guest.getId());
				
				statement.execute();
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

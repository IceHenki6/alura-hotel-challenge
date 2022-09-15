package com.federico.alurahotel.tests;

import java.sql.Connection;
import java.sql.SQLException;

import com.federico.alurahotel.factory.ConnectionFactory;


public class TestConnection {
	public static void main(String[] args) throws SQLException {
    	ConnectionFactory connectionFactory = new ConnectionFactory();
    	Connection con = connectionFactory.createConnection();

        System.out.println("Cerrando la conexión");

        con.close();
    }
}


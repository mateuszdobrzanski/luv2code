package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJbdc {

	public static void main(String[] args) {

		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-05-many-to-many?useSSL=false&&serverTimezone=UTC";
		String user = "hbstudent";
		String password = "hbstudent";
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			@SuppressWarnings("unused")
			Connection myConnection = 
					DriverManager.getConnection(jdbcUrl, user, password);
			
			System.out.println("Connection successfull!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}

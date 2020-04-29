package com.glbajaj.enroll.dao;

import java.sql.Connection;

public class DatabaseDaoImpl {
	static Connection con;
	public static Connection getConnection(){
		con=DatabaseConnection.getConnection();
		return con;
	}
}

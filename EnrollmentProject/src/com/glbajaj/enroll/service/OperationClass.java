package com.glbajaj.enroll.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.glbajaj.enroll.dao.DatabaseDaoImpl;

public class OperationClass {

	public static String doUpdate(int id,String tname,int seat) {
		String msg="";
		try {
			Connection con=new DatabaseDaoImpl().getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("update trainings set availableseats="+(seat-1)+" where trainingid="+id);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		msg="Hi you have successfully enrolled for "+tname+" Training.";
		return msg;
	}
	public static String doAdd(int id,String tname,int seat) {
		String msg="";
		try {
			Connection con=new DatabaseDaoImpl().getConnection();
			PreparedStatement stmt=con.prepareStatement("insert into trainings values(?,?,?)");  
			stmt.setInt(1,id);  
			stmt.setString(2,tname);
			stmt.setInt(3, seat);
			int i=stmt.executeUpdate();
			System.out.println(i);
			con.close();
		} catch (SQLException e) {
			return id+" training already added.";
		}
		msg= tname+" Training has Added Successfully";
		return msg;
	}
}

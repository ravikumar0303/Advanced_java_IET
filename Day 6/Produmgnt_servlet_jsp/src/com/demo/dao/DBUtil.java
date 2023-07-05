package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection con;
	
	public static Connection getMyConnection() {
		try {
				if(con==null) {
				
					DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
					//step2 : getConnection
					String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
					con=DriverManager.getConnection(url,"root","root123");
					if(con!=null) {
						System.out.println("connection done");
					}
					
					
				}
				return con;
		}catch(SQLException e) {
			System.out.println("error occured");
			return null;
		}
		
		
		
	}
	
	public static void closeMyConnection() {
		try {
		if(con!=null)
			con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

   }
}

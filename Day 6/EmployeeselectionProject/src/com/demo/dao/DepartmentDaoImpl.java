package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Department;

public class DepartmentDaoImpl implements DepartmentDao
{
   private static Connection conn;
   private static PreparedStatement psgetall;
   static {
	   conn=DBUtil.getMyConnection();
	   try {
		psgetall=conn.prepareStatement("select * from dept");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
@Override
public List<Department> getAlldepartments() {
	 try {
		ResultSet rs=psgetall.executeQuery();
		List<Department> dlist=new ArrayList<>();
		while(rs.next()) {
			dlist.add(new Department(rs.getInt(1),rs.getString(2),rs.getString(3)));
		}
		return dlist;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return null;
}
   
}

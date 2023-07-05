package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	private static Connection conn;
	private static PreparedStatement psgetbydept;
	   static {
		   conn=DBUtil.getMyConnection();
		   try {
			   psgetbydept=conn.prepareStatement("select empno,ename,deptno,sal from emp where deptno=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	@Override
	public List<Employee> findAllEmployees(int deptno) {
		try {
			psgetbydept.setInt(1, deptno);
			List<Employee> elist=new ArrayList<>();
			
			ResultSet rs=psgetbydept.executeQuery();
			while(rs.next()) {
				elist.add(new Employee(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4)));
			}
			return elist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void closeDBConnection() {
		DBUtil.closeMyConnection();
		
	}
}

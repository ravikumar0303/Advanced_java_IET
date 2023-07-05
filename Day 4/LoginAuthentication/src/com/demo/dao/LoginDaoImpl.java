package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.MyUser;
import com.demo.beans.RegisterUser;

public class LoginDaoImpl implements LoginDao{
    private static Connection conn;
    private static PreparedStatement pst,psins,psuserins;
    static {
    	conn=DBUtil.getMyConnection();
    	try {
			pst=conn.prepareStatement("select * from user where uname=? and password=?");
			psins=conn.prepareStatement("insert into registeruser values(?,?,?,?,?,?,?,?)");
			psuserins=conn.prepareStatement("insert into user values(?,?,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	@Override
	public MyUser authenticateUser(String uname, String passwd) {
		try {
			pst.setString(1, uname);
			pst.setString(2, passwd);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				return new MyUser(uname,passwd,rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public int registerUser(RegisterUser ob,MyUser u) {
		try {
			psins.setInt(1, ob.getUid());
			psins.setString(2, ob.getName());
			psins.setString(3, ob.getAddr());
			psins.setString(4, ob.getGender());
			
			psins.setString(5,ob.getSkills()[0]);
			// converting sql date to localdate using toLocalDate() method.
	        //LocalDate localDate1 = sqlDate.toLocalDate();
			//to convert LocalDate to Sql date
			java.sql.Date dt=java.sql.Date.valueOf(ob.getDt());
			psins.setDate(6, dt);
			psins.setString(7, ob.getCity());
			psins.setString(8,ob.getUname());
			psins.executeUpdate();
			psuserins.setString(1,u.getUname() );
			psuserins.setString(2, u.getPasswd());
			psuserins.setString(3, u.getRole());
			return psuserins.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	

	

}

package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao{
	private static Connection conn;
    private static PreparedStatement psgetall,psadd,psgetbyid,psupdate,psdel;
    static {
    	conn=DBUtil.getMyConnection();
    	try {
			psgetall=conn.prepareStatement("select * from product");
			psadd=conn.prepareStatement("insert into product values(?,?,?,?)");
			psgetbyid=conn.prepareStatement("select * from product where pid=?");
			psupdate=conn.prepareStatement("update product set qty=?,price=?,pname=? where pid=?");
			psdel=conn.prepareStatement("delete from product where pid=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	@Override
	public List<Product> findAllProducts() {
		try {
			ResultSet rs=psgetall.executeQuery();
			List<Product> plist=new ArrayList<>();
			while(rs.next()) {
				plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4)));
				
			}
			return plist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int saveProduct(Product p) {
		try {
			psadd.setInt(1, p.getPid());
			psadd.setString(2, p.getPname());
			psadd.setInt(3, p.getQty());
			psadd.setFloat(4, p.getPrice());
			return psadd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
		return 0;
	}

	@Override
	public Product findById(int pid) {
		try {
			psgetbyid.setInt(1, pid);
			ResultSet rs=psgetbyid.executeQuery();
			if(rs.next()) {
				return new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int modifyProduct(Product p) {
		try {
			psupdate.setInt(1, p.getQty());
		
		   psupdate.setFloat(2, p.getPrice());
		   psupdate.setString(3, p.getPname());
		   psupdate.setInt(4, p.getPid());
		   return psupdate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int removeById(int pid) {
			try {
				psdel.setInt(1, pid);
				return psdel.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
	}

}

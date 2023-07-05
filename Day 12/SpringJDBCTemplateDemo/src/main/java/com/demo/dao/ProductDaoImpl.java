package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void save(Product p) {
		int n=jdbcTemplate.update("insert into product values(?,?,?,?)",new Object[] {
			p.getPid(),p.getPname(),p.getQty(),p.getPrice()	
		});
		
	}

	/*@Override
	public List<Product> findAll() {
		List<Product> plist=jdbcTemplate.query("select * from product", new RowMapper(){

			@Override
			public Object mapRow(ResultSet rs, int rows) throws SQLException {
				Product p=new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setQty(rs.getInt(3));
				p.setPrice(rs.getFloat(4));
				return p;
			}
				});*/
	public List<Product> findAll() {
		
		List<Product> plist=jdbcTemplate.query("select * from product", (rs,rows)->{
				Product p=new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setQty(rs.getInt(3));
				p.setPrice(rs.getFloat(4));
				return p;
		
				});
		return plist;
	
	}

	@Override
	public Product findById(int id) {
		Product p=jdbcTemplate.queryForObject("select * from product where pid=?", 
				new Object[] {id},BeanPropertyRowMapper.newInstance(Product.class));
		return p;
	}

	@Override
	public List<Product> sortById() {
		List<Product> plist=jdbcTemplate.query("select * from product order by pid desc", (rs,num)->{
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(3));
			p.setPrice(rs.getFloat(4));
			return p;
		});
		return plist;
	}

	@Override
	public boolean removeById(int id) {
		int n=jdbcTemplate.update("delete from product where pid=?",new Object[] {id});
		return n>0;
	}

	@Override
	public boolean updateById(int id, int qty, float price) {
		System.out.println(qty+"    "+price);
		int n=jdbcTemplate.update("update product set qty=?,price=? where pid=?",
				new Object[] {qty,price,id});
		return n>0;
	}

}

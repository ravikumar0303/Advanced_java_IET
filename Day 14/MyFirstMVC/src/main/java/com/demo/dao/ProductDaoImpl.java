package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
     private JdbcTemplate jdbcTemplate;
	 
	@Override
	public List<Product> findAllProduct() {
		return jdbcTemplate.query("select * from product" ,(rs,num)->{
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setPrice(rs.getFloat(3));
			p.setQty(rs.getInt(4));
			return p;
		});
	}

	@Override
	public int save(Product p) {
		return jdbcTemplate.update("insert into product values(?,?,?,?)",new Object[] {
				p.getPid(),p.getPname(),p.getQty(),p.getPrice()});
		
	}

	@Override
	public Product findById(int pid) {
		return jdbcTemplate.queryForObject("select * from product where pid=?",new Object[] {pid},
				BeanPropertyRowMapper.newInstance(Product.class));
	}

	

	@Override
	public int modifyProduct(Product p) {
		return jdbcTemplate.update("update product set pname=?,qty=?,price=? where pid=?",new Object[] {
				p.getPname(),p.getQty(),p.getPrice(),p.getPid()});
		
	}

	@Override
	public int removeById(int pid) {
		return jdbcTemplate.update("delete from  product  where pid=?",new Object[] {
				pid});
	}
	

}

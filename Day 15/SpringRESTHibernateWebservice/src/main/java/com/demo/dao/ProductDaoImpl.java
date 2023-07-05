package com.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
    SessionFactory sessionFactory;

	public List<Product> findAll() {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Query query=session.createQuery("from Product p");
		List<Product> plist=query.list();
		tr.commit();
		session.close();
		return plist;
	}

	@Override
	public Product findById(int pid) {
		try {
			Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			Product p=session.get(Product.class,pid);
			tr.commit();
			session.close();
		    return p;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public int save(Product p) {
		try {
			Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			session.save(p);
			tr.commit();
			session.close();
		    return 1;
		}catch(DataAccessException e) {
			return 0;
		}
	}

	@Override
	public int modifyProduct(Product p) {
		
			Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			Product p1=session.get(Product.class,p.getPid());
			if(p1!=null) {
				p1.setPname(p.getPname());
				p1.setQty(p.getQty());
				p1.setPrice(p.getPrice());
				session.update(p1);
				tr.commit();
				session.close();
				return 1;
				
			}
			tr.commit();
			session.close();
			return 0;
			
			
	}

	@Override
	public int removeById(int pid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Product p1=session.get(Product.class,pid);
		if(p1!=null) {
			session.delete(p1);
			tr.commit();
			session.close();
			return 1;
		}
		tr.commit();
		session.close();
		return 0;
	}
}

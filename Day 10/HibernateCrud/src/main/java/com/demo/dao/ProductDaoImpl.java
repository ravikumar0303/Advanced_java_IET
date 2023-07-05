package com.demo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Order;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao{
  private static SessionFactory sf;
  static {
	  sf=HibernateUtil.getMySessionFactory();
  }
public void saveData(Product p) {
	Session sess=sf.openSession();
	Transaction tr=sess.beginTransaction();
	sess.save(p);
	tr.commit();
	sess.close();
	
}
@Override
public List<Product> findAllProduct() {
	Session sess=sf.openSession();
	Transaction tr=sess.beginTransaction();
	Query query=sess.createQuery("from Product");
	List<Product> plist=query.list();
	tr.commit();
	sess.close();
	return plist;
			
}
@Override
public Product findById(int pid) {
	Session sess=sf.openSession();
	Transaction tr=sess.beginTransaction();
	Product p=sess.get(Product.class, pid);
	tr.commit();
	sess.close();
	return p;
}
@Override
public boolean removeById(int pid) {
	Session sess=sf.openSession();
	Transaction tr=sess.beginTransaction();
	Product p=sess.get(Product.class, pid);
	if(p!=null) {
		sess.delete(p);
		tr.commit();
		sess.close();
		return true;
	}
	tr.commit();
	sess.close();
	return false;
	
}
@Override
public boolean modifyById(int pid, String pname, String wname) {
	Session sess=sf.openSession();
	Transaction tr=sess.beginTransaction();
	Product p=sess.get(Product.class, pid);
	if(p!= null) {
		p.setPname(pname);
		p.getWhouse().setWname(wname);
		//sess.saveOrUpdate(p);
		sess.update(p);
		//sess.merge(p)
		tr.commit();
		sess.close();
		return true;
	}
	tr.commit();
	sess.close();
	return false;
}
@Override
public List<Product> sortById() {
	Session sess=sf.openSession();
	Transaction tr=sess.beginTransaction();
	Query q=sess.createQuery("from Product p order by p.pid desc");
	List<Product> plist=q.list();
	tr.commit();
	sess.close();
	
	//Criteria cr=sess.createCriteria(Product.class,"p");
	//cr.addOrder(Order.asc("pid"));
	return plist;
}
@Override
public void closeConnection() {
	HibernateUtil.closeMySessiopnFacory();
	
}
}

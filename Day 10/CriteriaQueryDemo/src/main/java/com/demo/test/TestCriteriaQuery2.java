package com.demo.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.demo.beans.Product;

public class TestCriteriaQuery2 {
public static void main(String[] args) {
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	Session sess=sf.openSession();
	Transaction tr=sess.beginTransaction();
	Criteria cr=sess.createCriteria(Product.class);
	List<Product> plist=cr.list();
	plist.forEach(System.out::println);
	Criterion cr1=Restrictions.gt("price", 2000.0f);
	Criterion cr2=Restrictions.lt("qty", 200);
	Criteria cr3=sess.createCriteria(Product.class);
	LogicalExpression expr=Restrictions.or(cr1,cr2);
	cr3.add(expr);
	List<Product> plist1=cr3.list();
	plist1.forEach(System.out::println);
	//select * from product where qty>50
	
	
	tr.commit();
	sess.close();
	sf.close();
}
}

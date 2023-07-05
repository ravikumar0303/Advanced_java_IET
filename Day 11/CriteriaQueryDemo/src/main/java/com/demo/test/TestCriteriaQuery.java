package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Product;

public class TestCriteriaQuery {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Product p1=new Product(1,"Chair",34,2345);
		Product p2=new Product(2,"Table",45,3000);
		Product p3=new Product(3,"Shelf",25,567);
		Product p4=new Product(4,"Shoe rack",20,455);
		sess.save(p1);
		sess.save(p2);
		sess.save(p3);
		sess.save(p4);
		tr.commit();
		sess.close();
		sf.close();
	}

}

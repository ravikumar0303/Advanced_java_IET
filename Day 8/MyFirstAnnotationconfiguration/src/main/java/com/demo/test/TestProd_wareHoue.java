package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.MyUser;
import com.demo.beans.Product;
import com.demo.beans.Warehouse;

public class TestProd_wareHoue {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		/*MyUser u1=new MyUser("Revati","jdhjfkhd@dfgj");
		Warehouse w1=new Warehouse(123,"xxxx","Pune");
		Product p1=new Product(11,"chair",w1);
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		sess.save(u1);
		sess.save(p1);
		tr.commit();
		sess.close();*/
		
		Session sess1=sf.openSession();
		Product p=sess1.get(Product.class, 11);
		System.out.println(p);
		sf.close();
		

	}

}

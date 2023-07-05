package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.MyUser;

public class TestUserObject {

	public static void main(String[] args) {
		//object is in transient state
		//MyUser u1=new MyUser(13,"Rajan","aaaa@jskdf");
		//step 1 create session factory object
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		//step2 create session
		/*Session sess=sf.openSession();
		//sf.getCurrentSession();
		Transaction tr=sess.beginTransaction();
		sess.save(u1);
		tr.commit();
		sess.close();*/
		
		
		Session sess1=sf.openSession();
		//sf.getCurrentSession();
		Transaction tr1=sess1.beginTransaction();
		MyUser u2=sess1.get(MyUser.class,13);
		
		tr1.commit();
		System.out.println(u2);
		sess1.close();
		sf.close();

	}

}

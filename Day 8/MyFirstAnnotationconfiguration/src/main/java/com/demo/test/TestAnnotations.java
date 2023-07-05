package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.MyUser;

public class TestAnnotations {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		/*Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		MyUser u1=new MyUser("Rajan","jdhjfkhd@dfgj");
		sess.save(u1);
		tr.commit();
		sess.close();
		sf.close();*/
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		System.out.println("before");
		//MyUser u1=sess.load(MyUser.class,1);
		MyUser u1=sess.get(MyUser.class,1);
		System.out.println("after");
		System.out.println("uid: "+u1.getUid());
		System.out.println("uname: "+u1.getUname());
		tr.commit();
		sess.close();
		sf.close();
		
		

	}

}

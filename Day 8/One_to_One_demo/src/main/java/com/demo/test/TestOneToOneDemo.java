package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Address;
import com.demo.beans.Student;

public class TestOneToOneDemo {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Address a1=new Address(12,"baner","Pune");
		Student s1=new Student(100,"Rajan",a1);
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		sess.save(a1);
		sess.save(s1);
		tr.commit();
		sess.close();
		sf.close();
		

	}

}

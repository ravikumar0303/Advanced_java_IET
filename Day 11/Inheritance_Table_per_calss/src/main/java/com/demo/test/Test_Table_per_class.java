package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Employee;
import com.demo.beans.Student;

public class Test_Table_per_class {
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Employee e=new Employee(12,"Rajat","pune","HR","manager");
		Student s=new Student(13,"Swati","mumbai","DBDA",78);
		sess.save(e);
		sess.save(s);
		tr.commit();
		sess.close();
		sf.close();
	}

}

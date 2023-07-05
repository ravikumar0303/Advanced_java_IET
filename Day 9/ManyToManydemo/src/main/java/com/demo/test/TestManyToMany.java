package com.demo.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Employee;
import com.demo.beans.Project;

public class TestManyToMany {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Project p1=new Project(12,"proj1",4,null);
		Project p2=new Project(13,"proj2",3,null);
		Project p3=new Project(14,"proj3",4,null);
		Set<Project> sp1=new HashSet<>();
		sp1.add(p1);
		sp1.add(p2);
		Set<Project> sp2=new HashSet<>();
		sp2.add(p1);
		sp2.add(p3);
		Employee e1=new Employee(1,"Rajan",sp1);
		Employee e2=new Employee(2,"Revati",sp1);
		Employee e3=new Employee(3,"Anil",sp2);
		Set<Employee> se1=new HashSet<>();
		se1.add(e1);
		se1.add(e2);
		Set<Employee> se2=new HashSet<>();
		se2.add(e3);
		p1.setEset(se1);
		p2.setEset(se2);
		sess.save(e1);
		sess.save(e2);
		sess.save(e3);
		sess.save(p1);
		sess.save(p2);
		sess.save(p3);
		tr.commit();
		sess.close();
		sf.close();
		
		
		
		
		
		
		
	}

}

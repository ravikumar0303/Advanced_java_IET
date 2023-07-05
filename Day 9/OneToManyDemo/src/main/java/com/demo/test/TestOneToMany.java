package com.demo.test;



import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Address;
import com.demo.beans.MyUser;

public class TestOneToMany {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		/*Address a1=new Address(1,"baner","pune");
		Address a2=new Address(2,"aundh","pune");
		Set<Address> aset=new HashSet<>();
		aset.add(a1);
		aset.add(a2);
		MyUser u1=new MyUser(12,"Rajan",aset);
		a1.setMu(u1);
		a2.setMu(u1);
		sess.save(u1);
		sess.save(a1);
		sess.save(a2);*/
		MyUser u1=sess.get(MyUser.class,12);
		System.out.println(u1);
		tr.commit();
		sess.close();
		sf.close();

	}

}

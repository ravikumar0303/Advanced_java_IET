package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.MyUser;


public class TestBeans {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		MyUser u1=(MyUser)ctx.getBean("myUser");
		 
		System.out.println(u1);
		((ClassPathXmlApplicationContext)ctx).close();

	}

}

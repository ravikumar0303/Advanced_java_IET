package com.demo.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.demo.beans.HelloWorld;
import com.demo.beans.MyUser;
import com.demo.beans.Team;

public class TestSpringDemo {
 public static void main(String[] args) {
	/*HelloWorld hw=new HelloWorld();
	hw.sayHello();*/
	//create bean container
	 //XmlBeanFactory bf=new XmlBeanFactory(new ClassPathResource("springconfig.xml"));
	 ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
	 System.out.println("before getbean");
	 HelloWorld hbean=(HelloWorld)ctx.getBean("hw");
	 System.out.println("after getbean");
	 hbean.sayHello();
	 MyUser user1=(MyUser) ctx.getBean("u1");
	 System.out.println(user1);
	 Team t1=(Team)ctx.getBean("t1");
	 System.out.println(t1);
	 ((ClassPathXmlApplicationContext)ctx).close();
	 
}
}

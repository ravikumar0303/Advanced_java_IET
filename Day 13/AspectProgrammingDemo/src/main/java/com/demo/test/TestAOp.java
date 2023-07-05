package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.MyClass;
import com.demo.service.MyService;

public class TestAOp {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		MyClass c1=(MyClass)ctx.getBean("myClass");
		c1.method1();
		c1.getData(10);
		MyService ms=(MyService)ctx.getBean("myService");
		ms.method2();

	}

}

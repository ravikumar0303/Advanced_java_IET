package com.demo.test;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLocaleDemo {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springcfg.xml");
		Scanner sc=new Scanner(System.in);
		System.out.println("1. Marathi\n2. English uk\n3.English US\n4.Chinese\nChoice: ");
		int choice=sc.nextInt();
		MessageSource ms=(MessageSource) ctx.getBean("messageSource");
		String m=null,w=null,d=null,c=null;
		Locale locale=null;
		switch(choice) {
		case 1: 
			locale=new Locale("my","marathi");
			System.out.println("language: "+locale.getCountry()+"----"+locale.getLanguage());
			break;
			
		case 2:
			locale=Locale.UK;
			System.out.println("language: "+locale.getCountry()+"----"+locale.getLanguage());
			break;
		case 3:
			locale=new Locale("en","US");
			System.out.println("language: "+locale.getCountry()+"----"+locale.getLanguage());
			break;
		}
		m=ms.getMessage("msg.pay", null,locale);
		w=ms.getMessage("msg.welcome", new Object[] {"kishori"},locale);
		d=ms.getMessage("msg.data",null,locale);
		c=ms.getMessage("msg.currency", null,locale);
		System.out.println("Pay : "+m);
		System.out.println("Welcome: "+w);
		System.out.println("data: "+d);
				int amt=sc.nextInt();
		System.out.println("you entered : "+amt+c);
	}

}

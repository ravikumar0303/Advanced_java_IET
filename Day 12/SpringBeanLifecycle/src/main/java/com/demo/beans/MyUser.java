package com.demo.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyUser  implements BeanNameAware,BeanFactoryAware,ApplicationContextAware,DisposableBean{
	private int uid;
	private String uname;
	public MyUser() {
		super();
	}
	public MyUser(int uid, String uname) {
		super();
		this.uid = uid;
		this.uname = uname;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "MyUser [uid=" + uid + ", uname=" + uname + "]";
	}
	public void setBeanName(String name) {
		System.out.println("in setBean name"+name);
		
	}
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("in setBeanFactory"+beanFactory.toString());
		
	}
	public void afterPropertiesSet() throws Exception {
		System.out.println("after properties set");
		
	}
	public void destroy() throws Exception {
		System.out.println("In destroy method");
		
	}
	public void myinit() {
		System.out.println("in myinit method");
	}
	public void mydestroy() {
		System.out.println("in mydestroy method");
	}
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("in setapplicationcontextaware method");
		
	}
	

}

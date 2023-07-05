package com.demo.beans;

public class MyUser {
	private int uid;
	private String uname;
	private String email;

	
	  public MyUser() { 
		  super(); 
		  System.out.println("in default constructor"); }
	 
	public MyUser(int uid, String uname, String email) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.email = email;
		System.out.println("in parametrized constructor");
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		System.out.println("in set uid");
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		System.out.println("in set uname");
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		System.out.println("in set email");
		this.email = email;
	}
	@Override
	public String toString() {
		return "MyUser [uid=" + uid + ", uname=" + uname + ", email=" + email + "]";
	};
	

}

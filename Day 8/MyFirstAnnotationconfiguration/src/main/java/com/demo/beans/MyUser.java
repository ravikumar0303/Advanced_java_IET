package com.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//to allow creation of entity entry in the table
@Entity
//to specify table name otherwise a table with claa nsme will get created
@Table(name="myuser22")
public class MyUser {
  @Id  // it will make the column as primary key
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id")
  private int uid;
  private String uname;
  private String email;
	public MyUser() {
		super();
	}
	public MyUser( String uname, String email) {
		super();
		
		this.uname = uname;
		this.email = email;
	}
	public int getUid() {
		System.out.println("in get uid method");
		return uid;
	}
	public void setUid(int uid) {
		System.out.println("in set uid method");
		this.uid = uid;
	}
	public String getUname() {
		System.out.println("in get uname method");
		return uname;
	}
	public void setUname(String uname) {
		System.out.println("in set uname method");
		this.uname = uname;
	}
	public String getEmail() {
		System.out.println("in get email method");
		return email;
	}
	public void setEmail(String email) {
		System.out.println("in set email method");
		this.email = email;
	}
	@Override
	public String toString() {
		return "MyUser [uid=" + uid + ", uname=" + uname + ", email=" + email + "]";
	}
    
}

package com.demo.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="addr11")
public class Address {
   @Id	
   private int aid;
   private String street,city;
   @OneToOne(mappedBy="addr")
   Student s;
	public Address() {
		super();
	}
	
	public Address(int aid, String street, String city, Student s) {
		super();
		this.aid = aid;
		this.street = street;
		this.city = city;
		this.s = s;
	}

	public Student getS() {
		return s;
	}

	public void setS(Student s) {
		this.s = s;
	}

	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", street=" + street + ", city=" + city +"]";
	}
	
   
}

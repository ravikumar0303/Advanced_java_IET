package com.demo.beans;

public class Address {
	private int aid;
	private String street;
	public Address() {
		super();
	}
	public Address(int aid, String street) {
		super();
		this.aid = aid;
		this.street = street;
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
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", street=" + street + "]";
	}
	

}

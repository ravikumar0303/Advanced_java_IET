package com.demo.beans;

public class Product {
  private int pid,qty;
  private String pname;
  private float price;
	public Product() {
		super();
	}
	public Product(int pid,  String pname,int qty, float price) {
		super();
		this.pid = pid;
		this.qty = qty;
		this.pname = pname;
		this.price = price;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", qty=" + qty + ", pname=" + pname + ", price=" + price + "]";
	}
	 
}

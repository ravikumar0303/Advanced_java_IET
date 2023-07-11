package com.demo.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Size;

@Entity
public class Product {
  @Id
  private int pid;
  @NotBlank(message="pls enter value, name cannot be blank")
  @Size(min=3,max=12,message="the length should be between 3 to 12 characters")
  private String pname;
  @Min(value = 10)
  @Max(value = 50)
  private int qty;
  private float price;
public Product() {
	super();
}
public Product(int pid, String pname, int qty, float price) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.qty = qty;
	this.price = price;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
@Override
public String toString() {
	return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", price=" + price + "]";
}
  
}

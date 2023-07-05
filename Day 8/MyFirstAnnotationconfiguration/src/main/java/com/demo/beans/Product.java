package com.demo.beans;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prod12")
public class Product {
	@Id
	private int pid;
	private String pname;
	@Embedded
	private Warehouse whouse;
	public Product() {
		super();
	}
	
	public Product(int pid, String pname, Warehouse whouse) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.whouse = whouse;
	}

	public Warehouse getWhouse() {
		return whouse;
	}

	public void setWhouse(Warehouse whouse) {
		this.whouse = whouse;
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

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", whouse=" + whouse + "]";
	}
	
	

}

package com.demo.beans;

public class Employee {
	private int eid;
	private String ename;
	private float sal;
	public Employee() {
		super();
		System.out.println("in employee default constructor");
		
	}
	public Employee(int eid, String ename, float sal) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sal = sal;
	}
	public int getEid() {
		System.out.println("in getid");
		return eid;
	}
	public void setEid(int eid) {
		System.out.println("in seteid");
		this.eid = eid;
	}
	public String getEname() {
		System.out.println("in getname");
		return ename;
	}
	public void setEname(String ename) {
		System.out.println("in setename");
		this.ename = ename;
	}
	public float getSal() {
		System.out.println("in getsal");
		return sal;
	}
	public void setSal(float sal) {
		System.out.println("in setsal");
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", sal=" + sal + "]";
	}
	


}

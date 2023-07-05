package com.demo.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.*;

@Entity
@Table(name="emp11")
public class Employee {
	@Id
	private int empid;
	
	private String ename;
	@ManyToMany
	@JoinTable(name="emp_proj11",joinColumns= {@JoinColumn(name="e_eid")},
	inverseJoinColumns= {@JoinColumn(name="e_proj")})
	private Set<Project> pset;
	public Employee() {
		super();
	}
	public Employee(int empid, String ename, Set<Project> pset) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.pset = pset;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Set<Project> getPset() {
		return pset;
	}
	public void setPset(Set<Project> pset) {
		this.pset = pset;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", ename=" + ename + ", pset=" + pset + "]";
	}
	

}

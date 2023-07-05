package com.demo.beans;

public class Employee {
	private int empno;
	private String ename;
	private int deptno;
	private float sal;
	public Employee() {
		super();
	}
	public Employee(int empno, String ename, int deptno, float sal) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.deptno = deptno;
		this.sal = sal;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", deptno=" + deptno + ", sal=" + sal + "]";
	}
	@Override
	public int hashCode() {
		return  empno;
		
	}
	@Override
	public boolean equals(Object obj) {
		
		return empno == ((Employee)obj).empno;
			
	}
	

}

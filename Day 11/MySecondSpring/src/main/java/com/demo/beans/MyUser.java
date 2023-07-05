package com.demo.beans;

public class MyUser {
	private int pid;
	private String pname;
	private Address addr;
	public MyUser() {
		super();
	}
	public MyUser(int pid, String pname, Address addr) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.addr = addr;
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
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "MyUser [pid=" + pid + ", pname=" + pname + ", addr=" + addr + "]";
	}

}

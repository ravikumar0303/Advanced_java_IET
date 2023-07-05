package com.demo.beans;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name="stud12")
public class Student extends Person{
	private String course;
	private int marks;
	public Student() {
		super();
	}
	public Student(int pid, String pname, String address,String course, int marks) {
		super(pid,pname,address);
		this.course = course;
		this.marks = marks;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return super.toString()+"Student [course=" + course + ", marks=" + marks + "]";
	}
	

}

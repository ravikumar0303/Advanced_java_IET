package com.demo.beans;

public class Team {
  private int tid;
  private String name;
  private Player p1;
public Team() {
	super();
}
public Team(int tid, String name, Player p1) {
	super();
	this.tid = tid;
	this.name = name;
	this.p1 = p1;
}
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Player getP1() {
	return p1;
}
public void setP1(Player p1) {
	this.p1 = p1;
}
@Override
public String toString() {
	return "Team [tid=" + tid + ", name=" + name + ", p1=" + p1 + "]";
}

  
}

package com.demo.beans;

import java.util.List;

public class Team {
  private int tid;
  private String name;
  private List<Player> plist;
public Team() {
	super();
}

public Team(int tid, String name, List<Player> plist) {
	super();
	this.tid = tid;
	this.name = name;
	this.plist = plist;
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

public List<Player> getPlist() {
	return plist;
}

public void setPlist(List<Player> plist) {
	this.plist = plist;
}

@Override
public String toString() {
	return "Team [tid=" + tid + ", name=" + name + ", plist=" + plist + "]";
}


  
}

package com.demo.MyJWTHello.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {
	private String jwttoken;

	public JwtResponse(String jwttoken) {
		super();
		this.jwttoken = jwttoken;
	}

	public String getJwttoken() {
		return jwttoken;
	}

	@Override
	public String toString() {
		return "JwtResponse [jwttoken=" + jwttoken + "]";
	}

	
}

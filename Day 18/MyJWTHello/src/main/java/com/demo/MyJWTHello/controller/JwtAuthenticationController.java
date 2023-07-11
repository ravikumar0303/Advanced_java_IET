package com.demo.MyJWTHello.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.MyJWTHello.config.JwtTokenUtil;
import com.demo.MyJWTHello.model.JwtRequest;
import com.demo.MyJWTHello.model.JwtResponse;

@RestController
public class JwtAuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;

	
	     @PostMapping("/authenticate")
	     public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest){
	    	authenticate(authenticationRequest.getUsername(),authenticationRequest.getPassword());
	    	final UserDetails userDetails=jwtInMemoryUserDetailsService
	    			.loadUserByUsername(authenticationRequest.getUsername());
	    	final String token=jwtTokenUtil.generateToken(userDetails);
	    	return ResponseEntity.ok(new JwtResponse(token));
	    	 
	     }
	     
	     public void authenticate(String username,String password) {
	    	 Objects.requireNonNull(username);
	    	 Objects.requireNonNull(password);
	    	 try {
	    	 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password))
	    	 }catch(DisabledException e) {
	    		 throw new Exception("USER_DISABLED",e);
	    	 }catch(BadCredentialsException e) {
	    		 throw new Exception("INVALID_CREDENTIAL",e);
	    	 }
	     }
}

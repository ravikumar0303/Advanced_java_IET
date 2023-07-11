package com.demo.MyJWTHello.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.demo.MyJWTHello.service.JwtUserDetailService;

@Component
public class JwtRequestFiler extends OncePerRequestFilter  {
	@Autowired
	private JwtUserDetailService jwtuserService;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	 
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestHeader=request.getHeader("Autherization");
		String username=null;
		String jwtToken=null;
		
		//jwttoken  satrts with Bearer
		if(requestHeader!=null && requestHeader.startsWith("Bearer")){
			jwtToken=requestHeader.substring(7);
			try {
				username=jwtTokenUtil.getUsernameFromToken(jwtToken);
			}catch(IllegalArgumentException e) {
				System.out.println("unable to get JWTToken");
			}catch(ExpiredJwtException e) {
				System.out.println("JWT token has expired");
			}
			
			//once we get token validate it
			if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				UserDetails userdetails=jwtuserService.loadUserByUsername(username);
				
				//if valud token
				if(jwtTokenUtil.validateToken(jwtToken, userdetails)) {
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
					=new UsernamePasswordAuthenticationToken(userdetails,null,userdetails.getAuthorities());
					usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					
					//Our user is valid user
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				
				}
				
				filterChain.doFilter(request,response);
				
			}
		}
		
		
		
	}

}

package com.demo.MyJWTHello.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	private UserDetailsService jwtUserDetailsService;
	
	@Autowired
	private JwtRequestFiler jwtRequestFiler;
	
	private void configureGlobal(AuthenticationManagerBuilder auth) {
		
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
		
	}
	
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

}

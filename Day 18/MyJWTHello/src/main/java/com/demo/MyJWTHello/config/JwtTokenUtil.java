package com.demo.MyJWTHello.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;

@Component
public class JwtTokenUtil {
	
	public static final long JWT_TOKEN_VALIDITY= 5*60*60;
	
	@Value("${jwt.secret}")
	private String secret;
	
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token,Claims::getSubject);
	}
	
	public Date getIssuedAtDateFromToken(String token) {
		return getClaimFromToken(token,Claims::getIssuedAt);
		
	}
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token,Claims::getExpiration);
		
	}
	
	public <T> T getClaimFromToken(String token,Function<Claims,T> claimResolver) {
		final Claims claims=getAllClaimsFromToken(token);
		return claimResolver.apply(claims);
	}
	
	public Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
	
	private boolean istokenExpired(String token) {
		final Date expiration=getExpirationDateFromToken(token);
		return expiration.before(new Date());
		
	}
	
	private Boolean ignoreTokenExpiration(String token) {
		return false;
	}
	
	public String generateToken(UserDetails userdetails) {
		Map<String,Object> claims=new HashMap<>();
		return doGenarateToken(claims,userdetails.getUsername());
		
		
	}
	//the jwt token will get generated
	public String doGenarateToken(Map<String,Object> claims,String subject){
		return Jwts.builder().setClaim(claims).setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY)
				.signWith(SignatureAlgorithm.HS512,secret)).compact();
	}
	
	public Boolean canTokenBeRefreshed(String token) {
		return (!istokenExpired(token) || ignoreTokenExpiration(token));
		
	}
		
	public boolean validateToken(String token,UserDetails userdetails ) {
		final String username=getUsernameFromToken(token);
		return (username.equals(userdetails.getUsername()) && !istokenExpired(token));
	}

}

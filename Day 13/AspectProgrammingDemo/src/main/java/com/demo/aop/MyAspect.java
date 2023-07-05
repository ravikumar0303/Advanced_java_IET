package com.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	@Before("execution(* com.demo.*.*.method*(..))")
    public void beforeAdvice() {
    	System.out.println("in before advice");
    }
	
	@After("execution(* com.demo.*.*.*(..))")
    public void afterAdvice() {
    	System.out.println("in after advice");
    }
	@Around("execution(* com.demo.*.*.method*(..))")
	public Object  aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("in around advice before call");
		Object ob=joinPoint.proceed();
		System.out.println("in around advice after call");
		return ob;
		
		
	}
}

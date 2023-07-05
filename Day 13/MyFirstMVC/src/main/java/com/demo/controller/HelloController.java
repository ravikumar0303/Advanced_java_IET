package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/myhello")
public class HelloController {
	@RequestMapping("/")
	public String displayhomepage() {
		System.out.println("in display login");
		return "index";
	}
	
	@RequestMapping("/hello")
	public ModelAndView sayHello() {
		String message="this is message from say hello";
		//message data can be accessed in hello.jsp page by name msg
		return new ModelAndView("hello","msg",message);
	}

}

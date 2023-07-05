package com.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.MyUser;
import com.demo.service.LoginService;

@Controller
@RequestMapping("/mylogin")
public class LoginController {
	@Autowired
	LoginService loginService;

	//@RequestMapping("/login")
	@GetMapping("/login")
	public String showloginpage() {
		return "loginpage";
		
	}
	
	//@RequestMapping(value="/validate",method=RequestMethod.POST)
	
	  @PostMapping("/validate") 
	  public ModelAndView validateUser(HttpSession session,@RequestParam("uname") String unm,@RequestParam String passwd) {
		  MyUser u1=loginService.validateUser(unm,passwd); 
		  if(u1!=null) {
			  session.setAttribute("user", u1); 
			  //return new ModelAndView("hello","msg","success"); 
			  return new ModelAndView("redirect:/product/viewProduct");
	  
	  } else {
		  return new ModelAndView("loginpage","msg","pls reenter crendentials");
		  } 
   }
	 
	
}

package com.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.Product;
import com.demo.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/viewProduct")
	public ModelAndView displayAllProducts() {
		List<Product> plist=productService.getAllProducts();
		return new ModelAndView("displayproduct","plist",plist);
		
	}
	
	@GetMapping("/addnewproduct")
	public String displayproductform(Model model) {
		System.out.println("in add product");
		Product p=new Product();
		model.addAttribute("product",p);
		return "addProduct";
		
		
		
	}
	
	@PostMapping("/insertproduct")
	public ModelAndView insertProduct(@Valid @ModelAttribute("product") Product p,BindingResult result) {
		System.out.println("result :"+result);
		if(result.hasErrors()) {
			return new ModelAndView("addProduct","",null);
		}
		  productService.addProduct(p);
		  return new ModelAndView("redirect:/viewProduct");
	}
	
	@GetMapping("/edit/{pid}")
	public ModelAndView editProduct(@PathVariable int pid) {
		Product p=productService.getById(pid);
		if(p!=null) {
			return new ModelAndView("editproduct","product",p);
		}
		return new ModelAndView("redirect:/viewProduct");
		
	}
	
	@GetMapping("/delete/{pid}")
	public ModelAndView deleteProduct(@PathVariable int pid) {
		productService.deleteById(pid);
		
		return new ModelAndView("redirect:/viewProduct");
		
	}
	
	@PostMapping("/updateproduct")
	public ModelAndView updateProduct(@Valid @ModelAttribute Product p,BindingResult br) {
		if(br.hasErrors())
			return new ModelAndView("editproduct","",null);
		productService.updateProduct(p);
		return new ModelAndView("redirect:/viewProduct");
	}
	@GetMapping("/getbyprice/{lpr}/{hpr}")
	public ModelAndView getByPrice(@PathVariable int lpr,@PathVariable int hpr) {
		List<Product> plist=productService.getByPrice(lpr,hpr);
		return new ModelAndView("displaybyprice","plist",plist);
		
	}
	

}

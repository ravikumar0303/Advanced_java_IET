package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
		Product p=new Product();
		model.addAttribute("product",p);
		return "addproduct";
		
		
		
	}
	
	@PostMapping("/insertproduct")
	public ModelAndView insertProduct(@Valid @ModelAttribute("Product") Product p,BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("addproduct","",null);
		}
		  productService.addProduct(p);
		  return new ModelAndView("redirect:/viewproducts");
	}

}

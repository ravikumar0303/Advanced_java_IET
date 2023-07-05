package com.demo.test;

import java.util.Scanner;

import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class TestHibernateCrud {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	ProductService ps=new ProductServiceImpl();
	int choice=0;
	do {
	System.out.println("1. Add new product\n 2. Delete by id\n 3. Display all\n");
	System.out.println("4. display by Id\n 5. sort by id\n6. exit\nchoice: ");
	choice=sc.nextInt();
	switch(choice){
		case 1:
			break;
		case 6:
			System.out.println("Thank you for visiting...");
			break;
		default:
			System.out.println("wrong choice");
	}
	}while(choice!=6);
}
}

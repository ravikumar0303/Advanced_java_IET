package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class TestHibernateCrud {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	ProductService ps=new ProductServiceImpl();
	int choice=0;
	do {
	System.out.println("1. Add new product\n 2. Delete by id\n 3. Display all\n");
	System.out.println("4. display by Id\n 5. sort by id\n6. update by id\n7. exit\nchoice: ");
	choice=sc.nextInt();
	switch(choice){
		case 1:
			ps.addnewProduct_warehouse();
			break;
		case 2:
			System.out.println("enter product id");
			int pid=sc.nextInt();
			boolean status=ps.deleteById(pid);
			if(status) {
				System.out.println("deleted successfully");
			}
			else {
				System.out.println("not found");
			}
			break;
		case 3:
			List<Product> plist=ps.getAllProducts();
			plist.forEach(System.out::println);
			break;
		case 4:
			System.out.println("enter product id");
			pid=sc.nextInt();
			Product p=ps.getById(pid);
			if(p!=null) {
				System.out.println(p);
			}
			else {
				System.out.println("not found");
			}
			break;
		case 5:
			 plist=ps.sortById();
			 plist.forEach(System.out::println);
			
			break;
		case 6:
			System.out.println("enter product id");
			pid=sc.nextInt();
			System.out.println("enter productname");
			String pname=sc.next();
			System.out.println("enter warehousename");
			String wname=sc.next();
			status=ps.updateById(pid,pname,wname);
			if(status) {
				System.out.println("modified successfuly");
			}
			else {
				System.out.println("not found");
			}
			break;
		case 7:
			ps.closeSessionFactory();
			System.out.println("Thank you for visiting...");
			break;
		default:
			System.out.println("wrong choice");
	}
	}while(choice!=7);
}
}

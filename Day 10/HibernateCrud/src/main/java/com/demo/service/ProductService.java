package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	void addnewProduct_warehouse();

	List<Product> getAllProducts();

	Product getById(int pid);

	boolean deleteById(int pid);

	boolean updateById(int pid, String pname, String wname);

	List<Product> sortById();

	void closeSessionFactory();

}

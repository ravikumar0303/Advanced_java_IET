package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	List<Product> getAllProduct();

	void addNewProduct(Product p);

	Product getById(int pid);

	void updateProduct(Product p);

	int deleteById(int pid);

}

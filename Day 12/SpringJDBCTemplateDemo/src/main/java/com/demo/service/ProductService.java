package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	void addnewproduct();

	List<Product> displayAll();

	Product displayById(int id);

	List<Product> sortById();

	boolean deleteById(int id);

	boolean modifyById(int id, int qty, float price);

}

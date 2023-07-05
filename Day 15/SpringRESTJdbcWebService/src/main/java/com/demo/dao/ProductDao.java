package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> findAll();

	Product findById(int pid);

	int save(Product p);

	int modifyProduct(Product p);

	int removeById(int pid);

}

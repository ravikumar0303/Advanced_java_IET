package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> findAllProducts();

	int saveProduct(Product p);

	Product findById(int pid);

	int modifyProduct(Product p);

	int removeById(int pid);

}

package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	void save(Product p);

	List<Product> findAll();

	Product findById(int id);

	List<Product> sortById();

	boolean removeById(int id);

	boolean updateById(int id, int qty, float price);

}

package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	void saveData(Product p);

	List<Product> findAllProduct();

	Product findById(int pid);

	boolean removeById(int pid);

	boolean modifyById(int pid, String pname, String wname);

	List<Product> sortById();

	void closeConnection();

}

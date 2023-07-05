package com.demo.service;

import java.util.List;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;

	public ProductServiceImpl() {
		productDao=new ProductDaoImpl();
	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.findAllProducts();
	}

	@Override
	public int addProduct(Product p) {
		return productDao.saveProduct(p);
	}

	@Override
	public Product getById(int pid) {
		return productDao.findById(pid);
	}

	@Override
	public int updateProduct(Product p) {
		return productDao.modifyProduct(p);
	}

	@Override
	public int deleteById(int pid) {
		return productDao.removeById(pid);
	}
	

}

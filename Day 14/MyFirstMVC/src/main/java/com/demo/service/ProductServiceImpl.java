package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDao productDao;

	@Override
	public List<Product> getAllProduct() {
		return productDao.findAllProduct();
	}

	@Override
	public void addNewProduct(Product p) {
		 productDao.save(p);
		
	}

	@Override
	public Product getById(int pid) {
		return productDao.findById(pid);
	}

	@Override
	public void updateProduct(Product p) {
	 productDao.modifyProduct(p);
		
	}

	@Override
	public int deleteById(int pid) {
		return productDao.removeById(pid);
	}

}

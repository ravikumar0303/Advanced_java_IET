package com.demo.service;

import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
   private ProductDao prodDao;

public ProductServiceImpl() {
	super();
	this.prodDao = new ProductDaoImpl();
}
   
}

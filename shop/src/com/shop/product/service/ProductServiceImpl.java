package com.shop.product.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.entity.Product;
import com.shop.product.dao.ProductDaoImpl;

@Service
public class ProductServiceImpl {

	@Resource
	private ProductDaoImpl ProductDaoIpml;
	
	public List<Product> findAll(){
		List<Product> productlist = new ArrayList<Product>();
		productlist=this.ProductDaoIpml.findAll();
		return productlist;
	}

	public Product findById(int id) {
		Product p = this.ProductDaoIpml.findById(id);
		return p;
	}
}

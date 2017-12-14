package com.shop.product.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.entity.Order;
import com.shop.entity.OrderItem;
import com.shop.entity.Product;
import com.shop.entity.ProductType;
import com.shop.product.dao.ProductDaoImpl;

@Service
public class ProductServiceImpl {

	@Resource
	private ProductDaoImpl ProductDaoImpl;
	
	public List<Product> findAll(){
		List<Product> productlist = new ArrayList<Product>();
		productlist=this.ProductDaoImpl.findAll();
		return productlist;
	}

	public Product findById(int id) {
		Product p = this.ProductDaoImpl.findById(id);
		return p;
	}

	public List<ProductType> findAllType() {
		List<ProductType> pts = new ArrayList<ProductType>();
		pts=this.ProductDaoImpl.findAllType();
		return pts;
	}

	public List<Product> findByType(int typeid) {
		List<Product> productlist = new ArrayList<Product>();
		productlist=this.ProductDaoImpl.findByType(typeid);
		return productlist;
	}

	public void deleteById(Integer id) {
		this.ProductDaoImpl.deleteById(id);
		
	}
	@Transactional(readOnly=false)
	public void updateById(Product p, Integer id) {
		this.ProductDaoImpl.updateById(p,id);
		
	}

	public void addProduct(Product p) {
		this.ProductDaoImpl.addProduct(p);
		
	}

	public List<Product> findByName(String name) {
		List<Product> productlist = new ArrayList<Product>();
		productlist=this.ProductDaoImpl.findByName(name);
		return productlist;
	}

	public void deleteType(int id) {
		this.ProductDaoImpl.deleteType(id);
		
	}
	@Transactional(readOnly=false)
	public void addType(ProductType pt) {
		this.ProductDaoImpl.addProductType(pt);
		
	}
	@Transactional(readOnly=false)
	public List<OrderItem> findProList(int id) {
		List<OrderItem> orderItemlist = new ArrayList<OrderItem>();
		orderItemlist = this.ProductDaoImpl.findByOrderId(id);
		return orderItemlist;
	}

	public List<Product> findByDate() {
		List<Product> productlist = new ArrayList<Product>();
		productlist = this.ProductDaoImpl.findByDate();
		return productlist;
	}

	public List<Product> findByHot() {
		List<Product> productlist = new ArrayList<Product>();
		productlist = this.ProductDaoImpl.findByHot();
		return productlist;
	}
}

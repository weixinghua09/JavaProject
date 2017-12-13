package com.shop.order.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.entity.Order;
import com.shop.order.dao.OrderDaoImpl;
import com.shop.product.service.CartItem;

@Service
public class OrderServiceImpl {

	@Resource
	private OrderDaoImpl OrderDaoImpl;
	
	@Transactional(readOnly=false)
	public void saveOrder(Order order) {
		this.OrderDaoImpl.addOrder(order);
	}

	public List<Order> findByUserId(int userId) {
		List<Order> orderlist = (List<Order>)this.OrderDaoImpl.findByUserId(userId);
		return orderlist;
	}

	public void deleteById(int id) {
		this.OrderDaoImpl.deleteById(id);		
	}

	public Order findById(int id) {
		Order o = this.OrderDaoImpl.findById(id);
		return o;
	}
	
	public List<Order> findAllOrders() {
		List<Order> orderlist = this.OrderDaoImpl.findAllOrders();
		return orderlist;
	}

}

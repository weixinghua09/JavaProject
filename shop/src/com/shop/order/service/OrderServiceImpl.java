package com.shop.order.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.entity.Order;
import com.shop.order.dao.OrderDaoImpl;

@Service
public class OrderServiceImpl {

	@Resource
	private OrderDaoImpl OrderDaoImpl;
	
	public void saveOrder(Order order) {
		this.OrderDaoImpl.addOrder(order);
	}

}

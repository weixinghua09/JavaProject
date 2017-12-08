package com.shop.order.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.entity.Order;
import com.shop.order.dao.OrderDaoImpl;

@Service
public class OrderServiceImpl {

	@Resource
	private OrderDaoImpl OrderDaoImpl;
	
	@Transactional(readOnly=false)
	public void saveOrder(Order order) {
		this.OrderDaoImpl.addOrder(order);
	}

}

package com.shop.order.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.entity.Order;
import com.shop.entity.OrderItem;
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

	public Order findByOrder(Order order) {
		Order o = this.OrderDaoImpl.findByOrder(order);
		return o;
	}
	@Transactional(readOnly=false)
	public void saveOrderDetails(Order order, List<CartItem> itemlist) {
		List<OrderItem> orderitemlist = new ArrayList<OrderItem>();
		for (int i = 0; i < itemlist.size(); i++) {
			OrderItem oi = new OrderItem();
			CartItem ci= itemlist.get(i);
			oi.setOrderId(order.getId());
			oi.setProCount(ci.getCount());
			oi.setProId(ci.getProduct().getId());
			oi.setProName(ci.getProduct().getName());
			oi.setSmallPrice(ci.getSmallPrice());
			orderitemlist.add(oi);
		}
		this.OrderDaoImpl.saveOrderDetails(orderitemlist);
	}

}

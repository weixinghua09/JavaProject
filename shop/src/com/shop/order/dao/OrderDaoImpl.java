package com.shop.order.dao;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.shop.entity.Order;

@Repository
public class OrderDaoImpl {

	@Resource
	private SessionFactory sessionFactory;
	
	public void addOrder(Order o) {
		sessionFactory.getCurrentSession().save(o);
	}

}
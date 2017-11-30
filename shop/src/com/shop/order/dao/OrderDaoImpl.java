package com.shop.order.dao;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.shop.entity.Order;

@Repository
public class OrderDaoImpl {

	@Resource
	private SessionFactory sessionFactory;
	
	public void addOrder(Order o) {
		String sql = "insert into order(id,totalPrice,userid)values(?,?,?)";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
        if(o!=null){
				query.setParameter(0, o.getId());
				query.setParameter(1, o.getTotalPrice());
//				query.setParameter(2, o.getUser().getId());
				
		}
        query.executeUpdate();		
	}

}
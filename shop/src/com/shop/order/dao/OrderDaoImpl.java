package com.shop.order.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.shop.entity.Order;
import com.shop.entity.User;

@Repository
public class OrderDaoImpl {

	@Resource
	private SessionFactory sessionFactory;
	
	public void addOrder(Order o) {
		sessionFactory.getCurrentSession().save(o);
	}

	public List<Order> findByUserId(int userId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Order where userId=?");
		query.setParameter(0, userId);
		return query.list();
	}

	public void deleteById(int id) {
		String sql = "delete from orders where id=?";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter(0, id);
        query.executeUpdate();		
		
	}

	public Order findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Order where id=?");
		query.setParameter(0, id);
		Order o = (Order)query.uniqueResult();
		return o;
	}
	
	public List<Order> findAllOrders() {
		Query query=this.sessionFactory.getCurrentSession().createQuery("from "+Order.class.getSimpleName());
		return query.list();
	}

}
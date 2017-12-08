package com.shop.user.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.shop.entity.Product;
import com.shop.entity.User;


@Repository
public class UserDaoImpl{

	@Resource
	private SessionFactory sessionFactory;
	
	public User findByUsername(String userName){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where userName=?");
		query.setParameter(0, userName);
		User user = (User)query.uniqueResult();
		return user;
	}
	
	public void addUser(User u){
//		想用这个，但不报错，无法插入到数据库sessionFactory.getCurrentSession().save(u);
		String sql = "insert into user(userName,password,tpassword,email)values(?,?,?,?)";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
        if(u!=null){
				query.setParameter(0,u.getUserName());
				query.setParameter(1, u.getPassword());
				query.setParameter(2, u.getTpassword());
				query.setParameter(3, u.getEmail());
		}
        query.executeUpdate();
	}

	public void updateInfo(String userName, int age, String phone) {
		String sql = "update user set age=?,phone=? where userName=?";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter(2, userName);
        if(userName!=null){
				query.setParameter(0,age);
				query.setParameter(1,phone);
		}
        query.executeUpdate();
		
	}

	public List<User> findAll() {
		Query query=this.sessionFactory.getCurrentSession().createQuery("from "+User.class.getSimpleName());
		return query.list();
	}

	public void deleteById(Integer id) {
		String sql = "delete from user where id=?";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter(0, id);
        query.executeUpdate();
	}
}

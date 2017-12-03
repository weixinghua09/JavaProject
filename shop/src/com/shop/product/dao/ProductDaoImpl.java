package com.shop.product.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.shop.entity.Product;
import com.shop.entity.ProductType;

@Repository
public class ProductDaoImpl {

	@Resource
	private SessionFactory sessionFactory;
	
	public List<Product> findAll(){
		Query query=this.sessionFactory.getCurrentSession().createQuery("from "+Product.class.getSimpleName());
		return query.list();
	}

	public Product findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product where id=?");
		query.setParameter(0, id);
		Product p = (Product)query.uniqueResult();
		return p;
	}

	public List<ProductType> findAllType() {
		Query query=this.sessionFactory.getCurrentSession().createQuery("from "+ProductType.class.getSimpleName());
		return query.list();
	}

	public List<Product> findByType(int typeid) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product where typeid=?");
		query.setParameter(0,typeid);
		return query.list();
	}
}
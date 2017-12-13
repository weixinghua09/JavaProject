package com.shop.product.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.shop.entity.Order;
import com.shop.entity.OrderItem;
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

	public void deleteById(Integer id) {
		String sql = "delete from product where id=?";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter(0, id);
        query.executeUpdate();		
	}

	public void updateById(Product p, Integer id) {
		this.sessionFactory.getCurrentSession().update(p);
	}

	public void addProduct(Product p) {
		String sql = "insert into product (name,price,discount,description,typeid) values(?,?,?,?,?)";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
        if(p!=null){
				query.setParameter(0, p.getName());
				query.setParameter(1, p.getPrice());
				query.setParameter(2, p.getDiscount());
				query.setParameter(3, p.getDescription());
				query.setParameter(4, p.getTypeId());
		}
        query.executeUpdate();
		
	}

	public List<Product> findByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product where name like ?");
		query.setParameter(0,"%"+name+"%");
		return query.list();
	}

	public void deleteType(int id) {
		String sql = "delete from producttype where id=?";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter(0, id);
        query.executeUpdate();	
		
	}

	public void addProductType(ProductType pt) {
		sessionFactory.getCurrentSession().save(pt);
		
	}

	public List<OrderItem> findByOrderId(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from OrderItem where orderId=?");
		query.setParameter(0,id);
		return query.list();
	}

	public List<Product> findByDate() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product order by date");
		return query.list();
	}
}

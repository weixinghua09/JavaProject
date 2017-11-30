package com.shop.address.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.shop.entity.Address;

@Repository
public class AddressDaoImpl {

	@Resource
	private SessionFactory sessionFactory;
	
	public void addAddress(Address address, String userName) {
		String sql = "insert into address(userName,name,country,province,city,destination,postcode,phone)values(?,?,?,?,?,?,?,?)";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
        if(userName!=null&&address!=null){
				query.setParameter(0,userName);
				query.setParameter(1, address.getName());
				query.setParameter(2, address.getCountry());
				query.setParameter(3, address.getProvince());
				query.setParameter(4, address.getCity());
				query.setParameter(5, address.getDestination());
				query.setParameter(6, address.getPostcode());
				query.setParameter(7, address.getPhone());
		}
        query.executeUpdate();
		
	}

	public List<Address> findByUserName(String userName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Address where userName=?");
		query.setParameter(0, userName);
		List<Address> addresslist= query.list();
		return addresslist;
		
	}

	public Address findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Address where id=?");
		query.setParameter(0, id);
		Address address = (Address)query.uniqueResult();
		return address;
	}

	public void updateAddress(Address address) {
		String sql = "update address set name=?,country=?,province=?,city=?,destination=?,postcode=?,phone=? where id=?";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter(7, address.getId());
        if(address!=null){
				query.setParameter(0, address.getName());
				query.setParameter(1, address.getCountry());
				query.setParameter(2, address.getProvince());
				query.setParameter(3, address.getCity());
				query.setParameter(4, address.getDestination());
				query.setParameter(5, address.getPostcode());
				query.setParameter(6, address.getPhone());
		}
        query.executeUpdate();
		
	}

}

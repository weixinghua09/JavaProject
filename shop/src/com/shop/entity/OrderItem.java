package com.shop.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ORDERITEM")
public class OrderItem {

	private int id;
	private int orderId;
	private int proId;
	private String proName;
	private int proCount;
	private int smallPrice;
	
	@Id
	@GenericGenerator(name="native", strategy = "native")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public int getProCount() {
		return proCount;
	}
	public void setProCount(int proCount) {
		this.proCount = proCount;
	}
	public int getSmallPrice() {
		return smallPrice;
	}
	public void setSmallPrice(int smallPrice) {
		this.smallPrice = smallPrice;
	}
	
}

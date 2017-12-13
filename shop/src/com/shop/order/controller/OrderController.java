package com.shop.order.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.entity.Admin;
import com.shop.entity.Order;
import com.shop.entity.OrderItem;
import com.shop.entity.User;
import com.shop.order.service.OrderServiceImpl;
import com.shop.product.service.CartItem;
import com.shop.product.service.ProductServiceImpl;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Resource
	private OrderServiceImpl OrderServiceImpl;
	
	@Resource
	private ProductServiceImpl ProductSercviceImpl;
	
	@RequestMapping(value="/orderdetails", method=RequestMethod.GET)
	public String showOrderDetails(int id,Model model, HttpSession session){
		User user = (User)session.getAttribute("user");
		Admin admin = (Admin)session.getAttribute("admin");
		Order o = this.OrderServiceImpl.findById(id);
		List<OrderItem> orderItemlist = this.ProductSercviceImpl.findProList(id);
		session.setAttribute("orderItemlist", orderItemlist);
		session.setAttribute("order", o);
		session.setAttribute("admin",admin);
		session.setAttribute("user", user);
		return "uniqueorder";
	}
	
	@RequestMapping(value="/id", method=RequestMethod.POST)
	public String findById(@RequestParam("id") int id,Model model, HttpSession session){
		User user = (User)session.getAttribute("user");
		Order order = this.OrderServiceImpl.findById(id);		
		session.setAttribute("order", order);
		session.setAttribute("user", user);
		return "uniqueorder";
	}

	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteById(int id,Model model, HttpSession session){
		session.getAttribute("orderlist");
		User user = (User)session.getAttribute("user"); 
		this.OrderServiceImpl.deleteById(id);
		List<Order> orderlist = this.OrderServiceImpl.findByUserId(user.getId());
		session.setAttribute("orderlist", orderlist);
		session.setAttribute("user", user);
		
		return "myorder";
	}
	
	@RequestMapping(value="/myOrder", method=RequestMethod.GET)
	public String findByUserId(int userId,Model model, HttpSession session){
		User user = (User)session.getAttribute("user");
		Order o = new Order();
		o.setUser(user);
		o.getUser().setId(userId);
		List<Order> orderlist = this.OrderServiceImpl.findByUserId(userId);
		session.setAttribute("orderlist", orderlist);
		session.setAttribute("user", user);
		
		return "myorder";
	}
	
	@RequestMapping(value="/showOrder", method=RequestMethod.POST)
	public String showOrder(Model model, HttpSession session){
		List<CartItem> itemlist = (List<CartItem>)session.getAttribute("itemlist");
		User user = (User)session.getAttribute("user");
		session.setAttribute("itemlist", itemlist);
		session.setAttribute("user", user);
		
		return "order";
	}
	
	@RequestMapping(value="/generateOrder", method=RequestMethod.POST)
	public String generateOrder(Model model, HttpSession session){
		List<CartItem> itemlist = (List<CartItem>)session.getAttribute("itemlist");
		User user = (User)session.getAttribute("user");
		Order order = new Order();
		order.setUser(user);
		int totalPrice = 100;
		order.setTotalPrice(totalPrice);
		order.getUser().setId(user.getId());
		if(order!=null){
			this.OrderServiceImpl.saveOrder(order);
		}
		session.setAttribute("order", order);
		session.setAttribute("itemlist", itemlist);
		session.setAttribute("user", user);
		
		return "orderfinish";
	}
}
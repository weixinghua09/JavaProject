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
import com.shop.entity.Product;
import com.shop.entity.ProductType;
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
	private ProductServiceImpl ProductServiceImpl;
	
	@RequestMapping(value="/orderdetails", method=RequestMethod.GET)
	public String showOrderDetails(int id,Model model, HttpSession session){
		User user = (User)session.getAttribute("user");
		Admin admin = (Admin)session.getAttribute("admin");
		Order o = this.OrderServiceImpl.findById(id);
		List<OrderItem> orderItemlist = this.ProductServiceImpl.findProList(id);
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
	public String generateOrder(String name,Model model, HttpSession session){
		List<CartItem> itemlist = (List<CartItem>)session.getAttribute("itemlist");
		User user = (User)session.getAttribute("user");
		Order order = new Order();
		order.setUser(user);
		int totalPrice = 0;
		for (int i = 0; i < itemlist.size(); i++) {
			CartItem ci= itemlist.get(i);
			int price = ci.getProduct().getPrice();
			int count = ci.getCount();
			int smallPrice = price*count;
			ci.setSmallPrice(smallPrice);
			totalPrice = totalPrice+smallPrice;
		}
		order.setTotalPrice(totalPrice);
		order.setName(name);
		order.setStateId(0);
		order.getUser().setId(user.getId());
		if(order!=null){
			this.OrderServiceImpl.saveOrder(order);
//			this.OrderServiceImpl.saveOrderDetails(order,itemlist);
		}
		Order o = this.OrderServiceImpl.findByOrder(order);
		session.setAttribute("order", o);
		session.setAttribute("itemlist", itemlist);
		session.setAttribute("user", user);
		
		return "orderfinish";
	}
	
	@RequestMapping(value="/saveorderitem",method=RequestMethod.GET)
	public String saveOrderItem(Model model, HttpSession session){
		List<Product> productlist=this.ProductServiceImpl.findAll();
		List<ProductType> pts = this.ProductServiceImpl.findAllType();
		User user = (User)session.getAttribute("user");
		Order order = (Order)session.getAttribute("order");
		List<CartItem> itemlist = (List<CartItem>)session.getAttribute("itemlist");
		((Object) session).merge(order);
		this.OrderServiceImpl.saveOrderDetails(order,itemlist);
		if(productlist!=null){
			session.setAttribute("productlist", productlist);
			session.setAttribute("pts", pts);
			session.setAttribute("user", user);
			return "shop";
		}else{
			return "没有商品";
		}
	}
}
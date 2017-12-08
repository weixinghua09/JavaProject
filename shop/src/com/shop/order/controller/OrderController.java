package com.shop.order.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.entity.Order;
import com.shop.entity.Product;
import com.shop.entity.User;
import com.shop.order.service.OrderServiceImpl;
import com.shop.product.service.CartItem;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Resource
	private OrderServiceImpl OrderServiceImpl;

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
		
		return "order";
	}
}
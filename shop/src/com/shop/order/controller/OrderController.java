package com.shop.order.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.entity.Order;
import com.shop.order.service.OrderServiceImpl;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Resource
	private OrderServiceImpl OrderServiceImpl;

	@RequestMapping(value="/generateOrder", method=RequestMethod.GET)
	public String generateOrder(@RequestAttribute("itemlist") Model model, HttpSession session){
		Order order = new Order();
		order.setTotalPrice(100);
//		order.getUser().setId(1);
		if(order!=null){
			this.OrderServiceImpl.saveOrder(order);
		}
//		Iterator<CartItem> i = c.container.values().iterator();
//		while (i.hasNext()) {
//			CartItem ci = (CartItem) i.next();
//			itemlist.add(ci);
//		}
//		session.setAttribute("itemlist",itemlist);
//		List<CartItem> itemlist = new ArrayList<CartItem>();
//		session.getAttribute("itemlist");
		
		return "order";
	}
}
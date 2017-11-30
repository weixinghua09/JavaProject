package com.shop.cart.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.entity.Product;
import com.shop.product.service.Cart;
import com.shop.product.service.CartItem;
import com.shop.product.service.ProductServiceImpl;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Resource
	private ProductServiceImpl ProductServiceImpl;

	@RequestMapping(value="/showCart", method=RequestMethod.GET)
	public String showCart(Model model, HttpSession session){
		List<CartItem> itemlist = new ArrayList<CartItem>();
		
		Cart c = (Cart) session.getAttribute("cart");
		
		Iterator<CartItem> i = c.container.values().iterator();
		while (i.hasNext()) {
			CartItem ci = (CartItem) i.next();
			itemlist.add(ci);
		}
		session.setAttribute("itemlist",itemlist);
		return "cart";
	}
	
	@RequestMapping(value="/addCartiem", method=RequestMethod.GET)
	public String addCartItem(@RequestParam("id") int id,Model model, HttpSession session){
		Product p = this.ProductServiceImpl.findById(id);
		if(p!=null){
			Cart c = (Cart) session.getAttribute("cart");
			if (c == null) {
				c = new Cart();
			}
			c.addCart(p);
			session.setAttribute("cart", c);
			return "shop";
		}else{
			return "没有库存";
		}
	}
}

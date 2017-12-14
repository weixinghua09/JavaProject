package com.shop.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.admin.service.AdminServiceImpl;
import com.shop.entity.Admin;
import com.shop.entity.Order;
import com.shop.entity.Product;
import com.shop.entity.ProductType;
import com.shop.entity.User;
import com.shop.order.service.OrderServiceImpl;
import com.shop.product.service.ProductServiceImpl;
import com.shop.user.service.UserServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Resource
	private AdminServiceImpl AdminServiceImpl;
	
	@Resource
	private UserServiceImpl UserServiceImpl;
	
	@Resource
	private ProductServiceImpl ProductServiceImpl;
	
	@Resource
	private OrderServiceImpl OrderServiceImpl;
	
	//管理员登录
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("adminName") String adminName,
			@RequestParam("aPassword") String aPassword,
			Model model, HttpSession session){
		Admin admin=this.AdminServiceImpl.login(adminName, aPassword);
		if(admin!=null){
			session.setAttribute("admin", admin);
			return "admin";
		}else{
			model.addAttribute("errorinfo", "您的账号密码不正确！");
			return "adminlogin";
		}
	}
	//查询用户列表
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public String users(Model model, HttpSession session){
		Admin admin=(Admin)session.getAttribute("admin");
		List<User> userlist = new ArrayList<User>();
		userlist = this.UserServiceImpl.findAll();
		session.setAttribute("userlist", userlist);
		session.setAttribute("admin", admin);
		return "adminuser";
		
	}
	//查询商品列表
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public String edituser(Model model, HttpSession session){
		Admin admin=(Admin)session.getAttribute("admin");
		List<Product> productlist = new ArrayList<Product>();
		productlist = this.ProductServiceImpl.findAll();
		session.setAttribute("productlist", productlist);
		session.setAttribute("admin", admin);
		return "adminproduct";
		
	}
	//查询商品类型
	@RequestMapping(value="/category", method=RequestMethod.GET)
	public String adminCategory(Model model, HttpSession session){
		Admin admin = (Admin)session.getAttribute("admin");
		List<ProductType> categorylist = new ArrayList<ProductType>();
		categorylist = this.ProductServiceImpl.findAllType();
		session.setAttribute("categorylist",categorylist );
		session.setAttribute("admin", admin);
		return "admincategory";
	}
	//查询订单列表
	@RequestMapping(value="/orders", method=RequestMethod.GET)
	public String adminOrders(Model model, HttpSession session){
		Admin admin = (Admin)session.getAttribute("admin");
		List<Order> orderlist = new ArrayList<Order>();
		orderlist = this.OrderServiceImpl.findAllOrders();
		session.setAttribute("orderlist",orderlist );
		session.setAttribute("admin", admin);
		return "adminorders";
	}
}

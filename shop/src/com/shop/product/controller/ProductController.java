package com.shop.product.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.entity.Admin;
import com.shop.entity.Product;
import com.shop.entity.ProductType;
import com.shop.entity.User;
import com.shop.product.service.ProductServiceImpl;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Resource
	private ProductServiceImpl ProductServiceImpl;
	
	@RequestMapping(value="/hotproduct",method=RequestMethod.GET)
	public String hotProduct(Model model,HttpSession session){
		List<Product> productlist=this.ProductServiceImpl.findByHot();
		User user = (User)session.getAttribute("user");
		session.setAttribute("productlist", productlist);
		session.setAttribute("user", user);
		return "shop";
		
	}
	
	@RequestMapping(value="/newproduct",method=RequestMethod.GET)
	public String newProduct(Model model,HttpSession session){
		List<Product> productlist=this.ProductServiceImpl.findByDate();
		User user = (User)session.getAttribute("user");
		session.setAttribute("productlist", productlist);
		session.setAttribute("user", user);
		return "shop";
		
	}
	
	@RequestMapping(value="/addType",method=RequestMethod.POST)
	public String addType(@RequestParam("name") String name,Model model, HttpSession session){
		Admin admin = (Admin)session.getAttribute("admin");
		ProductType pt = new ProductType();
		pt.setName(name);
		this.ProductServiceImpl.addType(pt);
		List<ProductType> categorylist = new ArrayList<ProductType>();
		categorylist = this.ProductServiceImpl.findAllType();
		session.setAttribute("categorylist",categorylist );
		session.setAttribute("admin", admin);
		return "admincategory";
	}
	
	@RequestMapping(value="/deleteType",method=RequestMethod.GET)
	public String deleteType(int id,Model model, HttpSession session){
		Admin admin = (Admin)session.getAttribute("admin");
		this.ProductServiceImpl.deleteType(id);
		List<ProductType> categorylist = new ArrayList<ProductType>();
		categorylist = this.ProductServiceImpl.findAllType();
		session.setAttribute("categorylist",categorylist );
		session.setAttribute("admin", admin);
		return "admincategory";
	}
	
	@RequestMapping(value="/name",method=RequestMethod.POST)
	public String findByName(@RequestParam("name") String name,Model model, HttpSession session){
		Admin admin = (Admin)session.getAttribute("admin");
		List<Product> productlist=this.ProductServiceImpl.findByName(name);
		session.setAttribute("productlist", productlist);
		session.setAttribute("admin", admin);
		return "adminproduct";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addProduct(@RequestParam("name") String name,
			@RequestParam("price") int price,@RequestParam("discount") int discount,
			@RequestParam("description") String description,@RequestParam("typeId") int typeId,Integer id,Model model, HttpSession session){
		Admin admin = (Admin)session.getAttribute("admin");
		Product p = new Product();
		p.setName(name);
		p.setPrice(price);
		p.setDiscount(discount);
		p.setDescription(description);
		p.setTypeId(typeId);
		this.ProductServiceImpl.addProduct(p);
		List<Product> productlist=this.ProductServiceImpl.findAll();
		session.setAttribute("productlist", productlist);
		session.setAttribute("admin", admin);
		return "adminproduct";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateById(@RequestParam("id") int id,@RequestParam("name") String name,
			@RequestParam("price") int price,@RequestParam("discount") int discount,
			@RequestParam("description") String description,@RequestParam("typeId") int typeId,Model model, HttpSession session){
		Admin admin = (Admin)session.getAttribute("admin");
		Product p = new Product();	
		p.setId(id);
		p.setName(name);
		p.setPrice(price);
		p.setDiscount(discount);
		p.setDescription(description);
		p.setTypeId(typeId);
		this.ProductServiceImpl.updateById(p,id);
		List<Product> productlist=this.ProductServiceImpl.findAll();
		session.setAttribute("productlist", productlist);
		session.setAttribute("admin", admin);
		return "adminproduct";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String editById(Integer id,Model model, HttpSession session){
		Admin admin = (Admin)session.getAttribute("admin");
		Product p = this.ProductServiceImpl.findById(id);
		session.setAttribute("p", p);
		session.setAttribute("admin", admin);
		return "editproduct";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteById(Integer id,Model model, HttpSession session){
		Admin admin = (Admin)session.getAttribute("admin");
		this.ProductServiceImpl.deleteById(id);
		List<Product> productlist=this.ProductServiceImpl.findAll();
		session.setAttribute("productlist", productlist);
		session.setAttribute("admin", admin);
		return "adminproduct";
	}

	@RequestMapping(value="/type",method=RequestMethod.GET)
	public String findByType(@RequestParam("typeid") int typeid,Model model, HttpSession session){
		List<Product> productlist=this.ProductServiceImpl.findByType(typeid);
		if(productlist!=null){
			session.setAttribute("productlist", productlist);
			return "shop";
		}else{
			return "没有库存";
		}
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public String findAll(Model model, HttpSession session){
		List<Product> productlist=this.ProductServiceImpl.findAll();
		List<ProductType> pts = this.ProductServiceImpl.findAllType();
		User user = (User)session.getAttribute("user");
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

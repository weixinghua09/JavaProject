package com.shop.product.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.entity.Product;
import com.shop.entity.ProductType;
import com.shop.product.service.ProductServiceImpl;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Resource
	private ProductServiceImpl ProductServiceImpl;

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
		if(productlist!=null){
			session.setAttribute("productlist", productlist);
			session.setAttribute("pts", pts);
			return "shop";
		}else{
			return "没有商品";
		}
	}
}

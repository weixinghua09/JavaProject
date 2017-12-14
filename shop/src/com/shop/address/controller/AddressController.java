package com.shop.address.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.address.service.AddressServiceImpl;
import com.shop.entity.Address;
import com.shop.entity.User;
@Controller
@RequestMapping("/address")
public class AddressController {
	
	@Resource
	private AddressServiceImpl AddressServiceImpl;
	//删除地址
	@RequestMapping(value="/deleteaddress",method=RequestMethod.GET)
	public String deleteAddress(@RequestParam("id") int id,Model model,HttpSession session){
		this.AddressServiceImpl.deleteById(id);
		User user = (User)session.getAttribute("user");
		String userName = user.getUserName();
		List<Address> addresslist = this.AddressServiceImpl.findByUserName(userName);
		session.setAttribute("addresslist", addresslist);
		session.setAttribute("user", user);
		return "myaddress";
	}
	//更新地址
	@RequestMapping(value="/updateaddress",method=RequestMethod.POST)
	public String updateaddress(@RequestParam("name") String name,
			@RequestParam("country") String country,@RequestParam("province") String province,
			@RequestParam("city") String city,@RequestParam("destination") String destination,
			@RequestParam("postcode") String postcode,@RequestParam("phone") String phone, Model model,HttpSession session){
		User user = (User)session.getAttribute("user");
		Address address = (Address)session.getAttribute("address");
		address.setName(name);
		address.setCountry(country);
		address.setProvince(province);
		address.setCity(city);
		address.setDestination(destination);
		address.setPostcode(postcode);
		address.setPhone(phone);
		this.AddressServiceImpl.updateAddress(address);
		String userName = user.getUserName();
		List<Address> addresslist = this.AddressServiceImpl.findByUserName(userName);
		session.setAttribute("addresslist", addresslist);
		session.setAttribute("user", user);
		return "myaddress";
	}
	//修改地址
	@RequestMapping(value="/editaddress",method=RequestMethod.GET)
	public String editAddress(@RequestParam("id") int id,Model model,HttpSession session){
		Address address = this.AddressServiceImpl.findById(id);
		User user = (User)session.getAttribute("user");
		session.setAttribute("user", user);
		session.setAttribute("address", address);
		return "editaddress";
	}
	//用户查看自己的地址
	@RequestMapping(value="/myaddress",method=RequestMethod.GET)
	public String myAddress(String name,Model model,HttpSession session){
		User user = (User)session.getAttribute("user");
		String userName = user.getUserName();
		List<Address> addresslist = this.AddressServiceImpl.findByUserName(userName);
		session.setAttribute("addresslist", addresslist);
		session.setAttribute("user", user);
		return "myaddress";
	}
	//保存地址
	@RequestMapping(value="/saveaddress",method=RequestMethod.POST)
	public String saveAddress(@RequestParam("name") String name,
			@RequestParam("country") String country,@RequestParam("province") String province,
			@RequestParam("city") String city,@RequestParam("destination") String destination,
			@RequestParam("postcode") String postcode,@RequestParam("phone") String phone, Model model,HttpSession session){
		User user = (User)session.getAttribute("user");
		String userName = user.getUserName();
		Address address = new Address();
		address.setName(name);
		address.setCountry(country);
		address.setProvince(province);
		address.setCity(city);
		address.setDestination(destination);
		address.setPostcode(postcode);
		address.setPhone(phone);
		session.setAttribute("user", user);
		this.AddressServiceImpl.saveAddress(address,userName);
		return "online";
	}
}

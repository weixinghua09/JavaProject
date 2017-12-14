package com.shop.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.entity.Admin;
import com.shop.entity.User;
import com.shop.user.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserServiceImpl UserServiceImpl;
	//通过用户名关键字查询用户
	@RequestMapping(value="/userName", method=RequestMethod.POST)
	public String users(@RequestParam("keyword") String keyword,Model model, HttpSession session){
		Admin admin=(Admin)session.getAttribute("admin");
		List<User> userlist = new ArrayList<User>();
		userlist = this.UserServiceImpl.findByKeyword(keyword);
		session.setAttribute("userlist", userlist);
		session.setAttribute("admin", admin);
		return "adminuser";
		
	}
	//管理员按用户id删除用户
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteuser(Integer id,Model model, HttpSession session){
		Admin admin=(Admin)session.getAttribute("admin");
		this.UserServiceImpl.deleteById(id);
		List<User> userlist = new ArrayList<User>();
		userlist = this.UserServiceImpl.findAll();
		session.setAttribute("userlist", userlist);
		session.setAttribute("admin", admin);
		return "adminuser";
		
	}
	//用户管理地址
	@RequestMapping(value="/address",method=RequestMethod.GET)
	public String address(String userName,Model model,HttpSession session){
		User user = (User)session.getAttribute("user");
		session.setAttribute("user", user);
		return "address";
	}
	//更新个人资料
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@RequestParam("age")int age,@RequestParam("phone")String phone,Model model, HttpSession session){
		User user = (User)session.getAttribute("user");
		String userName = user.getUserName();
		this.UserServiceImpl.updateInfo(userName,age,phone);
		return "online";
	}
	//展示个人中心
	@RequestMapping(value="/showperson",method=RequestMethod.GET)
	public String showPerson(Model model, HttpSession session){
		User user = (User)session.getAttribute("user");
		User u = this.UserServiceImpl.findByUserName(user.getUserName());
		session.setAttribute("user", u);
		return "person";
	}
	//修改个人资料
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modify(Model model, HttpSession session){
		User user = (User)session.getAttribute("user");
		session.setAttribute("user", user);
		return "editperson";
	}
	//ajax验证用户名是否可用
	@ResponseBody
	@RequestMapping(value="/ajax", method=RequestMethod.POST)
	public String check(String userName,Model model, HttpSession session){
		User user=this.UserServiceImpl.findByUserName(userName);
		if(user!=null){
			return "no";
		}else{
			return "yes";
		}
	}
	//用户登录
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			Model model, HttpSession session){
		User user=this.UserServiceImpl.login(userName, password);
		if(user!=null){
			session.setAttribute("user", user);
			return "online";
		}else{
			model.addAttribute("errorinfo", "您的账号密码不正确！");
			return "login";
		}
	}
	//用户注册
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public String regist(@RequestParam("userName") String userName,
			@RequestParam("password") String password,@RequestParam("tpassword") String tpassword,
			@RequestParam("email") String email,
			Model model, HttpSession session){
		User user=this.UserServiceImpl.regist(userName, password,tpassword,email);
		if(user!=null){
			session.setAttribute("user", user);
			return "index";
		}else{
			return "regist";
		}
	}
}
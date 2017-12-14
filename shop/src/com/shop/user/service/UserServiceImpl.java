package com.shop.user.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.entity.User;
import com.shop.user.dao.UserDaoImpl;

@Service
public class UserServiceImpl {
	
	@Resource
	private UserDaoImpl UserDaoImpl;
	
	public User findByUserName(String userName){
		User user = this.UserDaoImpl.findByUsername(userName);
		if(user!=null){
			return user;
		}else{
			return null;
		}
	}
	
	public User login(String userName, String password){
		User user=this.UserDaoImpl.findByUsername(userName);
		if(user!=null){
			if(user.getPassword().equals(password)){
				return user;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	public User regist(String userName,String password,String tpassword,String email){
		if (password.equals(tpassword)) {
			User u = new User();
			u.setUserName(userName);
			u.setPassword(password);
			u.setTpassword(tpassword);
			u.setEmail(email);
			this.UserDaoImpl.addUser(u);
			return u;
		} else {
			return null;
		}		
	}

	public void updateInfo(String userName, int age, String phone) {
		this.UserDaoImpl.updateInfo(userName,age,phone);
		
	}

	public List<User> findAll() {
		List<User> userlist = new ArrayList<User>();
		userlist = this.UserDaoImpl.findAll();
		return userlist;
	}

	public void deleteById(Integer id) {
		this.UserDaoImpl.deleteById(id);
	}

	public List<User> findByKeyword(String keyword) {
		List<User> userlist = new ArrayList<User>();
		userlist = this.UserDaoImpl.findByKeyword(keyword);
		return userlist;
	}
}

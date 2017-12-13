package com.shop.admin.service;

import org.springframework.stereotype.Service;

import com.shop.entity.Admin;

@Service
public class AdminServiceImpl {

	public Admin login(String adminName, String aPassword) {
		if(adminName.equals("admin")&&aPassword.equals("admin")){
			Admin admin = new Admin();
			admin.setAdminName(adminName);
			admin.setaPassword(aPassword);
			return admin;
		}else{
			return null;
		}
		
	}

}

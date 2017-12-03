package com.shop.address.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.address.dao.AddressDaoImpl;
import com.shop.entity.Address;

@Service
public class AddressServiceImpl {

	@Resource
	private AddressDaoImpl AddressDaoImpl;

	public void saveAddress(Address address, String userName) {
		this.AddressDaoImpl.addAddress(address,userName);
		
	}

	public List<Address> findByUserName(String userName) {
		return this.AddressDaoImpl.findByUserName(userName);
		
	}

	public Address findById(int id) {
		Address address = this.AddressDaoImpl.findById(id);
		return address;
	}

	public void updateAddress(Address address) {
		this.AddressDaoImpl.updateAddress(address);
		
	}

	public void deleteById(int id) {
		this.AddressDaoImpl.deleteById(id);
	}
}

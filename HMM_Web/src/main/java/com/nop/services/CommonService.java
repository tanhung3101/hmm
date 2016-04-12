package com.nop.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nop.DTO.User;

public interface CommonService {

	public List<User> getUser() throws Exception;
	
	public User findUserByUserName(String userName) throws Exception;
	
}

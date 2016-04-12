package com.nop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nop.DAO.UserDAO;
import com.nop.DTO.User;

public class CommonServiceImpl implements CommonService {
	
	@Autowired
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO){
		this.userDAO=userDAO;
	}
	
	public CommonServiceImpl() {
	}
	
	@Override
	public List<User> getUser() throws Exception{
		if(userDAO!=null){
			List<User> lstUser=userDAO.getUsers();
			return lstUser;
		}else{
			return null;	
		}
	}

	@Override
	public User findUserByUserName(String userName) throws Exception {
		if(userDAO!=null){
			User user=userDAO.findUserByUserName(userName);
			return user;
		}else{
			return null;	
		}
	}


}

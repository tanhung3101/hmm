package com.nop.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nop.DTO.TemplateBill;
import com.nop.DTO.User;

public interface CommonService {

	public List<User> getUser() throws Exception;
	
	public User findUserByUserName(String userName) throws Exception;
	
	public List<TemplateBill> getTemplateBills() throws Exception;
	
	public TemplateBill addTemplateBill(TemplateBill temp) throws Exception;
	
	public void updateTemplateBill(TemplateBill temp) throws Exception;
	
	public void deleteTemplateBill(TemplateBill temp) throws Exception;
	
}

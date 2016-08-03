package com.nop.services;

import java.util.List;

import com.nop.DTO.Bill;
import com.nop.DTO.Person;
import com.nop.DTO.TemplateBill;
import com.nop.DTO.User;

public interface CommonService {

	public List<User> getUser() throws Exception;
	
	public User findUserByUserName(String userName) throws Exception;
	
	public List<TemplateBill> getTemplateBills() throws Exception;
	
	public TemplateBill addTemplateBill(TemplateBill temp) throws Exception;
	
	public void updateTemplateBill(TemplateBill temp) throws Exception;
	
	public void deleteTemplateBill(TemplateBill temp) throws Exception;
	
	
	public List<Person> getPersons() throws Exception;
	public Person addPerson(Person p) throws Exception;
	public void updatePerson(Person p) throws Exception;
	public void  deletePerson(Person p) throws Exception;
	public Person getPersonByID(int id) throws Exception;
	
	public List<Bill> getBills() throws Exception;
	public List<Bill> getBillsByMonth(String month) throws Exception;
	public Bill getBillByID(int id) throws Exception;
	public Bill addBill(Bill b) throws Exception;
	public void updateBill(Bill b) throws Exception;
	public void  deleteBill(int b) throws Exception;
	
	
}

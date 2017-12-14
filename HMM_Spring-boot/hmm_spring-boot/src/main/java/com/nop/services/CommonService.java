package com.nop.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nop.entity.Bill;
import com.nop.entity.Person;
import com.nop.entity.TemplateBill;
import com.nop.entity.User;

@Service
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
	
//	public List<Bill> getBills() throws Exception;
//	public List<Bill> getBillsByMonth(String month) throws Exception;
//	public Bill addBill(Bill b) throws Exception;
//	public void updateBill(Bill b) throws Exception;
//	public void  deleteBill(long b) throws Exception;
//	Bill getBillByID(long id) throws Exception;

	Person getPersonByID(long id) throws Exception;

	
	
}

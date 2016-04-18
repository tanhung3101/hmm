package com.nop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nop.DAO.BillDAO;
import com.nop.DAO.PersonDAO;
import com.nop.DAO.TemplateBillDAO;
import com.nop.DAO.UserDAO;
import com.nop.DTO.Bill;
import com.nop.DTO.Person;
import com.nop.DTO.TemplateBill;
import com.nop.DTO.User;

public class CommonServiceImpl implements CommonService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private TemplateBillDAO temBillDAO;
	
	@Autowired
	private BillDAO billDAO;
	
	@Autowired
	private PersonDAO personDAO;
	
	public void setUserDAO(UserDAO userDAO){
		this.userDAO=userDAO;
	}
	
	public CommonServiceImpl() {
	}
	
	public TemplateBillDAO getTemBillDAO() {
		return temBillDAO;
	}

	public void setTemBillDAO(TemplateBillDAO temBillDAO) {
		this.temBillDAO = temBillDAO;
	}

	public BillDAO getBillDAO() {
		return billDAO;
	}

	public void setBillDAO(BillDAO billDAO) {
		this.billDAO = billDAO;
	}

	public PersonDAO getPersonDAO() {
		return personDAO;
	}

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
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

	@Override
	public List<TemplateBill> getTemplateBills() throws Exception {
		if(temBillDAO!=null){
			List<TemplateBill> lstTempBill=temBillDAO.getTemplateBills();
			return lstTempBill;
		}else{
			return null;	
		}
	}

	@Override
	public TemplateBill addTemplateBill(TemplateBill temp) throws Exception {
		if(temBillDAO!=null){
			TemplateBill lstTempBill=temBillDAO.addTemplateBill(temp);
			return lstTempBill;
		}else{
			return null;	
		}
	}

	@Override
	public void updateTemplateBill(TemplateBill temp) throws Exception {
		if(temBillDAO!=null){
			temBillDAO.updateTemplateBill(temp);
		}
	}

	@Override
	public void deleteTemplateBill(TemplateBill temp) throws Exception {
		// TODO Auto-generated method stub
		if(temBillDAO!=null){
			temBillDAO.deleteTemplateBill(temp.getBillID());
		}
	}

	@Override
	public List<Person> getPersons() throws Exception {
		if(personDAO!=null){
			return	personDAO.getPersons();
		}
		return null;
	}

	@Override
	public Person addPerson(Person p) throws Exception {
		if(personDAO!=null){
			return	personDAO.addPerson(p);
		}
		return null;
	}

	@Override
	public void updatePerson(Person p) throws Exception {
		if(personDAO!=null){
			personDAO.updatePerson(p);
		}		
	}

	@Override
	public void deletePerson(Person p) throws Exception {
		// TODO Auto-generated method stub
		if(personDAO!=null){
			personDAO.deletePerson(p.getPersonID());
		}
	}

	@Override
	public List<Bill> getBills() throws Exception {
		// TODO Auto-generated method stub
		if(billDAO!=null){
			return billDAO.getBills();
		}
		return null;
	}

	@Override
	public Bill addBill(Bill b) throws Exception {
		// TODO Auto-generated method stub
		
		if(billDAO!=null){
			return billDAO.addBill(b);
		}
		return null;
	}

	@Override
	public void updateBill(Bill b) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBill(Bill b) throws Exception {
		// TODO Auto-generated method stub
		
	}


}

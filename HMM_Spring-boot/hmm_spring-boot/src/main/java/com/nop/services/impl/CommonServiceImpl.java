package com.nop.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nop.entity.Bill;
import com.nop.entity.Person;
import com.nop.entity.TemplateBill;
import com.nop.entity.User;
import com.nop.repository.BillRepository;
import com.nop.repository.PersonRepository;
import com.nop.repository.TemplateBillRepository;
import com.nop.repository.UserRepository;
import com.nop.services.CommonService;

@Service
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	private UserRepository userDAO;
	
	@Autowired
	private TemplateBillRepository temBillDAO;
	
	@Autowired
	private BillRepository billDAO;
	
	@Autowired
	private PersonRepository personDAO;
	

	@Override
	public List<User> getUser() throws Exception{
			List<User> lstUser=userDAO.findAll();
			return lstUser;
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
			List<TemplateBill> lstTempBill=temBillDAO.findAll();
			return lstTempBill;
	}

	@Override
	public TemplateBill addTemplateBill(TemplateBill temp) throws Exception {
			TemplateBill lstTempBill=temBillDAO.save(temp);
			return lstTempBill;
	}

	@Override
	public void updateTemplateBill(TemplateBill temp) throws Exception {
			temBillDAO.save(temp);
	}

	@Override
	public void deleteTemplateBill(TemplateBill temp) throws Exception {
		// TODO Auto-generated method stub
			temBillDAO.delete(temp.getBillID());
	}

	@Override
	public List<Person> getPersons() throws Exception {
			return	personDAO.findAll();
	}

	@Override
	public Person addPerson(Person p) throws Exception {
			return	personDAO.save(p);
	}

	@Override
	public void updatePerson(Person p) throws Exception {
			personDAO.save(p);
	}

	@Override
	public void deletePerson(Person p) throws Exception {
		// TODO Auto-generated method stub
			personDAO.delete(p.getPersonID());
	}

	@Override
	public Person getPersonByID(long id) throws Exception {
		// TODO Auto-generated method stub
			return personDAO.findOne(id);
	}

//	@Override
//	public List<Bill> getBills() throws Exception {
//		// TODO Auto-generated method stub
//			return billDAO.findAll();
//	}
//
//	@Override
//	public Bill addBill(Bill b) throws Exception {
//		// TODO Auto-generated method stub
//			return billDAO.save(b);
//	}
//
//	@Override
//	public void updateBill(Bill b) throws Exception {
//		// TODO Auto-generated method stub
//			billDAO.save(b);;
//	}
//
//	@Override
//	public void deleteBill(long id) throws Exception {
//		// TODO Auto-generated method stub
//			billDAO.delete(id);
//	}
//
//	@Override
//	public Bill getBillByID(long id) throws Exception {
//			return  billDAO.findOne(id);
//	}
//
//	@Override
//	public Person getPersonByID(long id) throws Exception {
//		// TODO Auto-generated method stub
//			return personDAO.findOne(id);
//	}
//
//	@Override
//	public List<Bill> getBillsByMonth(String month) throws Exception {
//		// TODO Auto-generated method stub
//			return billDAO.findBillByMonth(month);
//	}


}

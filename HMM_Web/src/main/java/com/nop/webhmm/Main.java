package com.nop.webhmm;

import java.util.List;

import org.hibernate.SessionFactory;

import com.nop.DAO.BillDAO;
import com.nop.DAO.PersonDAO;
import com.nop.DTO.Bill;
import com.nop.DTO.Person;

public class Main {
	  private static SessionFactory factory; 
	public static void main(String[] args) {
		
//		User user=new User("admin", "admin");
//		UserDAO userDAO=new UserDAO();
//		userDAO.getUsers();
		
		//create Person
		Person person=new Person("Nop");
		PersonDAO pd= new PersonDAO();
//		pd.addPerson(person);
		
		
		Bill b=new Bill("Dien","03/2016",150000.0,person);
		BillDAO bd= new BillDAO();
		bd.addBill(b);
		
		List<Bill> bills= bd.getBills();
		
		for(Bill bi:bills){
			System.out.println(bi.getPayer().getPersonName());
			System.out.println(bi.getPayer().getPersonID());
		}
			
		
	}

}

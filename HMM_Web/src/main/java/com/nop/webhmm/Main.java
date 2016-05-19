package com.nop.webhmm;

import java.util.List;
import java.util.Random;

import org.hibernate.SessionFactory;

import com.nop.DAO.BillDAO;
import com.nop.DAO.PersonDAO;
import com.nop.DAO.TemplateBillDAO;
import com.nop.DTO.Bill;
import com.nop.DTO.Person;
import com.nop.DTO.TemplateBill;

public class Main {
	  private static SessionFactory factory; 
	public static void main(String[] args) {
		
//		User user=new User("admin", "admin");
//		UserDAO userDAO=new UserDAO();
//		userDAO.getUsers();
		
		//create Person
//		Person person=new Person("Nop");
//		PersonDAO pd= new PersonDAO();
////		pd.addPerson(person);
//		
//		
////		Bill b=new Bill("Dien","03/2016",150000.0,person);
//		BillDAO bd= new BillDAO();
////		bd.addBill(b);
//		
//		List<Bill> bills= bd.getBills();
//		
////		for(Bill bi:bills){
////			System.out.println(bi.getPayer().getPersonName());
////			System.out.println(bi.getPayer().getPersonID());
////		}
//			
//		TemplateBill temp1=new TemplateBill("Water");
//		TemplateBill temp2=new TemplateBill("Electricity");
//		TemplateBill temp3=new TemplateBill("Internet");
//		
//		
//		TemplateBillDAO td=new TemplateBillDAO();
////		td.addTemplateBill(temp1);
////		td.addTemplateBill(temp2);
////		td.addTemplateBill(temp3);
//		
//		List<TemplateBill> lstTemp= td.getTemplateBills();
//		
//		BillDAO db=new BillDAO();
//		
//		Bill bi=new Bill("Water", "3/2016",150000.0);
//		Bill bi2=new Bill("Water", "3/2016",150000.0);
//		
//		db.addBill(bi);
//		db.addBill(bi2);
		
		for(int i=0;i<10;i++){
			System.out.println(1 + new Random().nextInt(50));
		}
		
		
		
	}

}


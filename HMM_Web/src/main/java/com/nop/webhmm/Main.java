package com.nop.webhmm;

import java.util.List;

import org.hibernate.SessionFactory;

import com.nop.DAO.UserDAO;
import com.nop.DTO.User;

public class Main {
	  private static SessionFactory factory; 
	public static void main(String[] args) {
		
		User user=new User("admin", "admin");
		UserDAO userDAO=new UserDAO();
		userDAO.getUsers();
//      List<User>lstUser=	session.createCriteria(User.class).list();
      
//      for(User u:lstUser){
//    	  if(u.getUserID()==2){
//    		  session.delete(u);
//    	  }
//      }
//      session.persist(user);
//         transaction.commit();
	}

}

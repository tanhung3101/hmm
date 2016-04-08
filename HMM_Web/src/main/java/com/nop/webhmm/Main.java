package com.nop.webhmm;

import org.hibernate.SessionFactory;

import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.nop.DTO.User;

public class Main {
	  private static SessionFactory factory; 
	public static void main(String[] args) {
		
		User user=new User("admin", "admin");
		
		Session session = HibernateUtil.getInstance().getSession();
         System.out.println("session : "+session);
      Transaction   transaction = session.beginTransaction();
//      session.get();
         transaction.commit();
	}

}

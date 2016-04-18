package com.nop.DAO;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nop.DTO.Person;
import com.nop.webhmm.HibernateUtil;

public class PersonDAO {
	private static final Logger logger = Logger.getLogger(PersonDAO.class);
	 Session session = null;
	public PersonDAO(){
		
	}
	
	public List<Person> getPersons() {
       Session session = null;
       logger.info(this.toString()+"-start getPersons()");
       try {
           session = HibernateUtil.getInstance().getSession();
           Query query = session.createQuery("from Person s");

           List queryList = query.list();
           if (queryList != null && queryList.isEmpty()) {
               return (List<Person>) queryList;
           } else {
               logger.info("list " + queryList);
               return (List<Person>) queryList;
           }
       } catch (Exception e) {
       	 logger.error("PersonDAO"+"-start getPersons():"+e.getMessage());
           return null;
       } finally {
           session.close();
       }
   }

   public Person findPersonById(int id) {
       Session session = null;
       logger.info(this.toString()+"-start findPersonById()");
       try {
           session = HibernateUtil.getInstance().getSession();
           Query query = session.createQuery("from Person s where s.id = :id");
           query.setParameter("id", id);

           List queryList = query.list();
           if (queryList != null && queryList.isEmpty()) {
               return null;
           } else {
               return (Person) queryList.get(0);
           }
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       } finally {
           session.close();
       }
   }
   
   public Person findPersonByPersonName(String PersonName) {
       Session session = null;
       logger.info(this.toString()+"-start findPersonByPersonName()");
       try {
           session = HibernateUtil.getInstance().getSession();
           Query query = session.createQuery("from Person s where s.PersonName = :PersonName");
           query.setParameter("PersonName", PersonName);

           List queryList = query.list();
           if (queryList != null && queryList.isEmpty()) {
               return null;
           } else {
               return (Person) queryList.get(0);
           }
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       } finally {
           session.close();
       }
   }

   public void updatePerson(Person Person) {
       Session session = null;
       try {
           session = HibernateUtil.getInstance().getSession();
           session.saveOrUpdate(Person);
           session.flush();
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           session.close();
       }
   }

   public Person addPerson(Person Person) {
       Session session = null;
       Transaction transaction = null;
       try {
           session = HibernateUtil.getInstance().getSession();
           System.out.println("session : "+session);
           transaction = session.beginTransaction();
           session.save(Person);
           transaction.commit();
           return Person;
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }

   public void deletePerson(int id) {
       Session session = null;
       try {
           session = HibernateUtil.getInstance().getSession();
           Transaction beginTransaction = session.beginTransaction();
           Query createQuery = session.createQuery("delete from Person s where s.id =:id");
           createQuery.setParameter("id", id);
           createQuery.executeUpdate();
           beginTransaction.commit();
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           session.close();
       }
   }
}

package com.nop.DAO;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.nop.DTO.User;
import com.nop.webhmm.HibernateUtil;

@Component
public class UserDAO {
	private static final Logger logger = Logger.getLogger(UserDAO.class);
	 Session session = null;
	public UserDAO(){
		
	}
	
	public List<User> getUsers() {
        Session session = null;
        logger.info(this.toString()+"-start getUsers()");
        try {
            session = HibernateUtil.getInstance().getSession();
            Query query = session.createQuery("from User s");
 
            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                logger.info("list " + queryList);
                return (List<User>) queryList;
            }
        } catch (Exception e) {
        	 logger.error("UserDAO"+"-start getUsers():"+e.getMessage());
            return null;
        } finally {
            session.close();
        }
    }
 
    public User findUserById(int id) {
        Session session = null;
        logger.info(this.toString()+"-start findUserById()");
        try {
            session = HibernateUtil.getInstance().getSession();
            Query query = session.createQuery("from User s where s.id = :id");
            query.setParameter("id", id);
 
            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return (User) queryList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    
    public User findUserByUserName(String userName) {
        Session session = null;
        logger.info(this.toString()+"-start findUserByUserName()");
        try {
            session = HibernateUtil.getInstance().getSession();
            Query query = session.createQuery("from User s where s.userName = :userName");
            query.setParameter("userName", userName);
 
            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return (User) queryList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
 
    public void updateUser(User User) {
        Session session = null;
        try {
            session = HibernateUtil.getInstance().getSession();
            session.saveOrUpdate(User);
            session.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
 
    public User addUser(User User) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getInstance().getSession();
            System.out.println("session : "+session);
            transaction = session.beginTransaction();
            session.save(User);
            transaction.commit();
            return User;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
 
    public void deleteUser(int id) {
        Session session = null;
        try {
            session = HibernateUtil.getInstance().getSession();
            Transaction beginTransaction = session.beginTransaction();
            Query createQuery = session.createQuery("delete from User s where s.id =:id");
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

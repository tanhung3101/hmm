package com.nop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nop.DTO.Bill;
import com.nop.webhmm.HibernateUtil;

public class BillDAO {
	private static final Logger logger = LoggerFactory.getLogger(BillDAO.class);
	 Session session = null;
	public BillDAO(){

	}

	public List<Bill> getBills() {
       Session session = null;
       logger.info(this.toString()+"-start getBills()");
       try {
           session = HibernateUtil.getInstance().getSession();
           Query query = session.createQuery("from Bill s");

//           List queryList = query.list();
//           if (queryList != null && queryList.isEmpty()) {
//               return null;
//           } else {
//               logger.info("list " + queryList);
//               return (List<Bill>) queryList;
//           }
           return session.createCriteria(Bill.class).list();

       } catch (Exception e) {
       	 logger.error("BillDAO"+"-start getBills():"+e.getMessage());
           return null;
       } finally {
           session.close();
       }
   }

   public Bill findBillById(int id) {
       Session session = null;
       logger.info(this.toString()+"-start findBillById()");
       try {
           session = HibernateUtil.getInstance().getSession();
           Query query = session.createQuery("from Bill s where s.id = :id");
           query.setParameter("id", id);

           List queryList = query.list();
           if (queryList != null && queryList.isEmpty()) {
               return null;
           } else {
               return (Bill) queryList.get(0);
           }
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       } finally {
           session.close();
       }
   }

   public Bill findBillByBillName(String BillName) {
       Session session = null;
       logger.info(this.toString()+"-start findBillByBillName()");
       try {
           session = HibernateUtil.getInstance().getSession();
           Query query = session.createQuery("from Bill s where s.BillName = :BillName");
           query.setParameter("BillName", BillName);

           List queryList = query.list();
           if (queryList != null && queryList.isEmpty()) {
               return null;
           } else {
               return (Bill) queryList.get(0);
           }
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       } finally {
           session.close();
       }
   }

   public List<Bill> findBillByMonth(String month) {
       Session session = null;
       logger.info(this.toString()+"-start findBillByBillName()");
       try {
           session = HibernateUtil.getInstance().getSession();
           Query query = session.createQuery("from Bill s where s.month = :month");
           query.setParameter("month", month);

          java.util.List queryList = query.list();
           if (queryList != null && queryList.isEmpty()) {
               return null;
           } else {
               return (java.util.List<Bill>) queryList;
           }
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       } finally {
           session.close();
       }
   }

   public void updateBill(Bill Bill) {
       Session session = null;
//       Transaction transaction = null;
       try {
           session = HibernateUtil.getInstance().getSession();
//           transaction = session.beginTransaction();
           session.saveOrUpdate(Bill);
//           transaction.commit();
           session.flush();
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           session.close();
       }
   }

   public Bill addBill(Bill Bill) {
       Session session = null;
       Transaction transaction = null;
       try {
           session = HibernateUtil.getInstance().getSession();
           System.out.println("session : "+session);
           transaction = session.beginTransaction();
           session.save(Bill);
           transaction.commit();
           return Bill;
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }

   public void deleteBill(int id) {
       Session session = null;
       try {
           session = HibernateUtil.getInstance().getSession();
           Transaction beginTransaction = session.beginTransaction();
           Query createQuery = session.createQuery("delete from Bill s where s.id =:id");
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

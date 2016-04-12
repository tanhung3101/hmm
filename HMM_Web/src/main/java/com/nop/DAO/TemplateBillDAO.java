package com.nop.DAO;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nop.DTO.TemplateBill;
import com.nop.webhmm.HibernateUtil;

public class TemplateBillDAO {
	private static final Logger logger = Logger.getLogger(TemplateBillDAO.class);
	 Session session = null;
	public TemplateBillDAO(){
		
	}
	
	public List<TemplateBill> getTEMPLATE_BILLs() {
      Session session = null;
      logger.info(this.toString()+"-start getTEMPLATE_BILLs()");
      try {
          session = HibernateUtil.getInstance().getSession();
          Query query = session.createQuery("from TEMPLATE_BILL s");

//          List queryList = query.list();
//          if (queryList != null && queryList.isEmpty()) {
//              return null;
//          } else {
//              logger.info("list " + queryList);
//              return (List<TEMPLATE_BILL>) queryList;
//          }
          return session.createCriteria(TemplateBill.class).list();
          
      } catch (Exception e) {
      	 logger.error("TemplateTEMPLATE_BILLDAO"+"-start getTEMPLATE_BILLs():"+e.getMessage());
          return null;
      } finally {
          session.close();
      }
  }

  public TemplateBill findTEMPLATE_BILLById(int id) {
      Session session = null;
      logger.info(this.toString()+"-start findTEMPLATE_BILLById()");
      try {
          session = HibernateUtil.getInstance().getSession();
          Query query = session.createQuery("from TEMPLATE_BILL s where s.id = :id");
          query.setParameter("id", id);

          List queryList = query.list();
          if (queryList != null && queryList.isEmpty()) {
              return null;
          } else {
              return (TemplateBill) queryList.get(0);
          }
      } catch (Exception e) {
          e.printStackTrace();
          return null;
      } finally {
          session.close();
      }
  }
  
  public TemplateBill findTEMPLATE_BILLByName(String BILL_DESCRIPTION) {
      Session session = null;
      logger.info(this.toString()+"-start findTEMPLATE_BILLByName()");
      try {
          session = HibernateUtil.getInstance().getSession();
          Query query = session.createQuery("from TEMPLATE_BILL s where s.BILL_DESCRIPTION = :BILL_DESCRIPTION");
          query.setParameter("BILL_DESCRIPTION", BILL_DESCRIPTION);

          List queryList = query.list();
          if (queryList != null && queryList.isEmpty()) {
              return null;
          } else {
              return (TemplateBill) queryList.get(0);
          }
      } catch (Exception e) {
          e.printStackTrace();
          return null;
      } finally {
          session.close();
      }
  }

  public void updateTEMPLATE_BILL(TemplateBill TEMPLATE_BILL) {
      Session session = null;
      try {
          session = HibernateUtil.getInstance().getSession();
          session.saveOrUpdate(TEMPLATE_BILL);
          session.flush();
      } catch (Exception e) {
          e.printStackTrace();
      } finally {
          session.close();
      }
  }

  public TemplateBill addTEMPLATE_BILL(TemplateBill TEMPLATE_BILL) {
      Session session = null;
      Transaction transaction = null;
      try {
          session = HibernateUtil.getInstance().getSession();
          System.out.println("session : "+session);
          transaction = session.beginTransaction();
          session.save(TEMPLATE_BILL);
          transaction.commit();
          return TEMPLATE_BILL;
      } catch (Exception e) {
          e.printStackTrace();
          return null;
      }
  }

  public void deleteTEMPLATE_BILL(int id) {
      Session session = null;
      try {
          session = HibernateUtil.getInstance().getSession();
          Transaction beginTransaction = session.beginTransaction();
          Query createQuery = session.createQuery("delete from TEMPLATE_BILL s where s.id =:id");
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

package com.nop.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
 
public class HibernateUtil {
 
	private static HibernateUtil me;
    private Configuration cfg;
    private SessionFactory sessionFactory;
 
    private HibernateUtil() throws HibernateException {
 
        // build the config
        cfg = new Configuration().configure();
         
        sessionFactory = cfg.buildSessionFactory();
    }
 
    public static synchronized HibernateUtil getInstance() throws HibernateException {
        if (me == null) {
            me = new HibernateUtil();
        }
 
        return me;
    }
 
    public Session getSession() throws HibernateException {
        Session session = sessionFactory.openSession();
        if (!session.isConnected()) {
            this.reconnect();
        }
        return session;
    }
 
    private void reconnect() throws HibernateException {
        this.sessionFactory = cfg.buildSessionFactory();
    }
}
     

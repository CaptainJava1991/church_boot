package com.agnc.carthy.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    private static Session session;
    
    private HibernateUtil(){
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        session = sessionFactory.openSession();
    }
   
    
    
    public static Session getSession() {
    	if(session == null){
    		new HibernateUtil();
    	}else if(!session.isOpen()){
    		session = sessionFactory.openSession();
    	}
        return session;
    }
}

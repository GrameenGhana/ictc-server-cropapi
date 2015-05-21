/*
 * @Copyright Grameen Foundation
 */

package com.grameenfoundation.cropinfoapp.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Joseph George Davis
 * @date Mar 20, 2015 11:23:35 AM
 * description:creates hibernate session factory
 */
public class HibernateUtil {
    
    private static final SessionFactory sessionFactory;
	
    static{
		try{
			sessionFactory = new  AnnotationConfiguration().configure().buildSessionFactory();
                         
		} 
		catch(Throwable ex){
			System.out.println("Initial SessionFactory creation failed. "+ex);
			//ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}

}

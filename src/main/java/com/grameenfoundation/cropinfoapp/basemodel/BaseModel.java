/*
 * @Copyright Grameen Foundation
 */

package com.grameenfoundation.cropinfoapp.basemodel;

import com.grameenfoundation.cropinfoapp.utilities.HibernateUtil;
import com.grameenfoundation.cropinfoapp.utilities.CropUtil;
import com.grameenfoundation.cropinfoapp.utilities.DbServiceInterface;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Joseph George Davis
 * @param <T>
 * @date Mar 20, 2015 11:00:44 AM
 * description:Generic Class to handle all generic CRUD Activities
 */


public abstract class BaseModel<T extends BaseEntity> implements DbServiceInterface{
    
     private static final Logger LOGGER = Logger.getLogger(BaseModel.class.getName());
     
     private Class<T> entityClass;

    public BaseModel(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    public String getEntityClassName()
    {
        return entityClass.getSimpleName();
    }
    
    
    //Generic Create Method
     public boolean create(T entity) {
         
        //Get hibernate session
        Session session =  HibernateUtil.getSessionFactory().openSession();
        Transaction transaction  = null;
        try{
            LOGGER.log(Level.INFO, "in create method");
            entity.setCreatedDate(CropUtil.getDate());
            entity.setLastModified(CropUtil.getDate());
            entity.setCreatedBy("ICT challenge");
            entity.setLastModifiedBy("ICT challenge");

            //begin transaction
            transaction= session.beginTransaction();
            //save entity
            session.save(entity);
            
            //commit transaction
            transaction.commit();
            
             LOGGER.log(Level.INFO, "saved {0}", getEntityClassName());
            return true;
        } catch (HibernateException hibernateException) {
            LOGGER.log(Level.SEVERE,"Error saving " + getEntityClassName() + " with id : " + entity.toString(), hibernateException);
            
             
            
            System.out.println("Exception " +hibernateException.getLocalizedMessage());
            if(transaction != null){
                transaction.rollback();
            }
            return false;
        
        }finally{
             LOGGER.log(Level.INFO, "closing session");
             session.close();
        }
    }
     
     
     //Generic update 
     
        public boolean update(T entity) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        Transaction transaction  = null;
        try {
            
            //entity.setCreatedDate(CropUtil.getDate());
            entity.setLastModified(CropUtil.getDate());
            
             //begin transaction
            transaction = session.beginTransaction();
            
            //save entity
            session.update(entity);
            
             //commit transaction
            transaction.commit();
            
            LOGGER.log(Level.INFO, "updated {0}", getEntityClassName());
            
            return true;
        } catch (HibernateException hibernateException) {
            LOGGER.log(Level.SEVERE,"Error updating " + getEntityClassName() + " with id : " + entity.toString(), hibernateException);
            if(transaction != null){
                transaction.rollback();
            }
            return false;
        }catch(Exception exception){
            LOGGER.log(Level.SEVERE,"Error updating " + getEntityClassName() + " with id : " + entity.toString(), exception);
            return false;
        }finally{
            
            LOGGER.log(Level.INFO, "closing session");
            session.close();
        }
    }
        
        
        //Generic delete
      public boolean delete(T entity) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            //begin transaction
            transaction = session.beginTransaction();
            
             //save entity
            session.delete(entity);
            
             //commit transaction
            transaction.commit();
            return true;
        } catch (HibernateException hibernateException) {
            LOGGER.log(Level.SEVERE,"Error deleting " + getEntityClassName() + " with id : " + entity.toString(), hibernateException);
            if(transaction != null){
                transaction.rollback();
            }
            return false;
        }catch(Exception exception){
             LOGGER.log(Level.SEVERE,"Error deleting " + getEntityClassName() + " with id : " + entity.toString(), exception);
            return false;
        }finally{
            
            LOGGER.log(Level.INFO, "closing session");
            session.close();
        }
    }
      
      
      
      //generic find all
       public List<T> findAll() {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        try {
            //create find all query
            final String SQL_QUERY = "SELECT e FROM " + getEntityClassName() + " AS e ORDER BY e.id DESC";

            Query query = session.createQuery(SQL_QUERY);

            return query.list();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,"Error retrieving all " + getEntityClassName() + "s ", e);
            return Collections.EMPTY_LIST;
        }finally{
            session.close();
        }
    }
       
       
       //find by id
       public T findById(String id) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        
        //create find by id query
        try {
            final String SQL_QUERY = "FROM " + getEntityClassName() + " AS e WHERE e.id = :id";

            Query query = session.createQuery(SQL_QUERY);
            query.setString("id", id);

            return (T) query.uniqueResult();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,"Error finding " + getEntityClassName() + " with id : " + id, e);
            return null;
        }finally{
            session.close();
        }
    }

}

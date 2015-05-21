/*
 * @copyright Grameen Foundation
 */

package com.grameenfoundation.cropinfoapp.models;

import com.grameenfoundation.cropinfoapp.basemodel.BaseModel;
import com.grameenfoundation.cropinfoapp.entities.CropDetail;
import com.grameenfoundation.cropinfoapp.utilities.HibernateUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Joseph George Davis
 * @date Mar 20, 2015 12:38:16 PM
 * description: Model to handle database manipulation
 */
public class CropDetailModel extends BaseModel<CropDetail> {

    private static final Logger LOGGER = Logger.getLogger(CropDetailModel.class.getName());
    
    public CropDetailModel(Class<CropDetail> entityClass) {
        super(entityClass);
    }
    
    
     public CropDetailModel() {
        super(CropDetail.class);
    }
     
     
     public CropDetail getActivity(String crop,String region,int month)
     {
         LOGGER.info("in get Activity");
         LOGGER.log(Level.INFO, "month {0}", month);
         LOGGER.log(Level.INFO, "crop {0}", crop);
         LOGGER.log(Level.INFO, "region {0}", region);
          
         
         //open hibernate session
         Session session = HibernateUtil.getSessionFactory().openSession();
         
         //hibernate query to execute
         String query = "From CropDetail  where crop=:crop and region=:region and startMonth<=:month"+
                          " and endMonth>=:month ORDER BY id DESC ";
         
         LOGGER.log(Level.INFO,"query {0}",query);
         Transaction tx = null;
        
         try {
             //begin transaction
             tx = session.beginTransaction();
             
             //execute query to return crop object
             CropDetail cropDetail = (CropDetail)session.createQuery(query)
                     .setParameter("crop",crop )
                     .setParameter("region",region)
                     .setParameter("month",String.valueOf(month)).uniqueResult();
             
             if(null!=cropDetail)
             {
                 LOGGER.log(Level.INFO,"Crop Details retrieved successfuly {0}",cropDetail.getActivity());
                
                 return cropDetail;
                 
             }
             else
             {
                  LOGGER.log(Level.INFO,"Crop Details retrieval failed");
             }
             
              
          tx.commit();   
         } catch (Exception e) {
             LOGGER.log(Level.INFO, "Crop Details retrieval Failed {0}", e.getLocalizedMessage());
             e.printStackTrace();
             return null;
         }
         finally
         {
             //closes session
             session.close();
         }
         
         return null;
     }
     
     
     
     public CropDetail getActivity(String crop,String region,String date)
     {
         
         //open hibernate session
         Session session = HibernateUtil.getSessionFactory().openSession();
         
         CropDetail detail = null;
         //String queryStr="From CropDetail where  startDate<='"+date+"' and endDate>='"+date+"'";
         String queryStr = "From CropDetail  where crop=:crop and region=:region and startDate<='"+date+"' and endDate>='"+date+"'";
         
          LOGGER.log(Level.INFO,"query {0}",queryStr);
          List <CropDetail> resultset =null;
          
          
		       try {

             resultset = (List<CropDetail>) session.createQuery(queryStr)
                     .setParameter("crop", crop)
                     .setParameter("region", region)
                     .list();
             if (resultset.size() > 0) {
                 LOGGER.log(Level.INFO, "result is available");
                 detail = resultset.get(0);

             } else {
                 detail = null;
             }
         } catch (Exception ex) {
             LOGGER.log(Level.INFO, ex.getLocalizedMessage());
             detail = null;

         }
         return detail;
     }
     
     

}

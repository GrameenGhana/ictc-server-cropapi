/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.cropinfo.manager;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.grameenfoundation.cropinfoapp.entities.CropDetail;
import com.grameenfoundation.cropinfoapp.models.CropDetailModel;
import com.grameenfoundation.cropinfoapp.utilities.FactoryId;
import com.grameenfoundation.cropinfoapp.utilities.ModelFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joseph George Davis
 * @date Mar 27, 2015 11:51:41 AM
 * description: Class to manage methods that create the JSON objects
 */
public class CropDetailManager {
    
    private static final Logger LOGGER = Logger.getLogger(CropDetailManager.class.getName());
    
    public  JsonObject cropDetailJSON(String[] crops,String region,String date)
    {
         LOGGER.info("in JSON Object");
         
        JsonObject jsonObject = new JsonObject();
       
        CropDetail cropDetail = null;
        //get crop detail Model  object
        CropDetailModel cropDetailModel =  (CropDetailModel) ModelFactory.getModel(FactoryId.CROPDETAIL);
         
        
        jsonObject.addProperty("rc","00");
        
        JsonArray jsonArray = new JsonArray();
        
        for (String crop : crops) {
            
            JsonObject json = new JsonObject();
             
             cropDetail = cropDetailModel.getActivity(crop, region, date);
             
             LOGGER.log(Level.INFO,"Crop Details retrieval failed {0}",cropDetail);
             
             if(null!=cropDetail)
             {
               json.addProperty("crop",cropDetail.getCrop());
               json.addProperty("activity",cropDetail.getActivity());
             }
             else
             {
                 json.addProperty("crop",crop);
                 json.addProperty("activity","no activity");
                 
             }
             
            jsonArray.add(json);
        }
        
        jsonObject.add("cropDtl", jsonArray);
        
       return jsonObject;
    }
    
    

}

/*
* @copyright Grameen Foundation
*/

package com.grameenfoundation.cropinfoapp.utilities;

import com.grameenfoundation.cropinfoapp.models.CropDetailModel;

/**
 *
 * @author Joseph George Davis
 * @date Mar 20, 2015 12:25:30 PM
 * description:
 */
public class ModelFactory {
    
    
     //method to modulate models in factory
    
    public static DbServiceInterface  getModel(FactoryId factoryId)
    {
        switch(factoryId){
            
            case CROPDETAIL:
                 return new CropDetailModel();
            
        }
        
        
        return null;
    }

}

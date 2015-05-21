/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.cropinfoapp.utilities;

import com.grameenfoundation.cropinfoapp.entities.CropDetail;
import com.grameenfoundation.cropinfoapp.models.CropDetailModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grameen
 */
public class DateTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            String  currentDate= "2015-03-18";
            
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dt.parse(currentDate);
            
            SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
            d.format(date);
            System.out.println(d.format(date));
            
            //get month from calendar instance
            Calendar c = Calendar.getInstance();
            //c.setTime(new Date());
             
            System.out.println("month " +c.toString());
            
            
        } catch (ParseException ex) {
            Logger.getLogger(DateTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

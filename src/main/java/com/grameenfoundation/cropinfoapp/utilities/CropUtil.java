/*
 * @copyright Grameen Foundation
 */

package com.grameenfoundation.cropinfoapp.utilities;

import java.io.IOException;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joseph George Davis
 * @date Mar 20, 2015 11:36:19 AM
 * description:Class for utility methods
 */
public class CropUtil {
     private static final Logger LOGGER = Logger.getLogger(CropUtil.class.getName());
     
     public static final String GENERAL_RESPONSE = "generalResponse";
     public static final String ERROR = "error";
     public static final String SUCCESS = "success";

    
     public static Date getDate()
     {
         
         return new Date();
     }
     
   public static void redirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
		  	 
        try {
            String path = "";
            if (request.getHeader("referer") != null) {
                path = request.getHeader("referer");
            } else if (url != null || url == "") {
                path = url;
            } else {
                path = request.getContextPath();
            }
            
            request.getRequestDispatcher(url).forward(request, response);
            return;
        } catch (Exception e) {
            //System.out.println("Error Occured : " + e.toString());
            e.printStackTrace();
            return;
        }
    }
     
     
     
     
     
     
     
   public static int getMonthFromDate(String currentDate)
     {
         LOGGER.log(Level.INFO, "current date {0}", currentDate);
         
         try {
             SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
             Date date = dt.parse(currentDate);
             
             //get month from calendar instance
             Calendar c = Calendar.getInstance();
             c.setTime(date);
             
             return c.get(Calendar.MONTH)+1;
             
         } catch (ParseException ex) {
             Logger.getLogger(CropUtil.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         return 0;
     }
   
   
   public static String getMonthInString(int month) {
      // System.out.println("month " + month);
       return new DateFormatSymbols().getMonths()[month-1];
     
}
   
   public static Date strtoDate(String date)
   {
       Date pDate;
         try {
             SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
             Date parsedDate = dt.parse(date);
             pDate= parsedDate;
         } catch (ParseException ex) {
             //Logger.getLogger(CropUtil.class.getName()).log(Level.SEVERE, null, ex);
             Calendar c = Calendar.getInstance();
             c.setTime(new Date());
             
             c.set(Calendar.YEAR,Integer.parseInt(date));
             pDate=c.getTime();
         }
         
        return pDate;
   }
   
   
   
   public static String getFormattedDate(Date date)
   {
       SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
       d.format(date);
       return d.format(date);
   }
   
   
   

}

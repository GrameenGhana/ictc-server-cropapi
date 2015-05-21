/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.cropinfoapp.controllers;

import com.grameenfoundation.cropinfoapp.entities.CropDetail;
import com.grameenfoundation.cropinfoapp.models.CropDetailModel;
import com.grameenfoundation.cropinfoapp.utilities.CropUtil;
import com.grameenfoundation.cropinfoapp.utilities.FactoryId;
import com.grameenfoundation.cropinfoapp.utilities.ModelFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joseph George Davis
 */
@WebServlet(name = "CropServlet", urlPatterns = {"/CropServlet"})
public class CropServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
              CropDetailModel cropDetailModel = (CropDetailModel) ModelFactory.getModel(FactoryId.CROPDETAIL);
              String action = null;
              
             
                action = request.getParameter("action").trim();
                System.out.println("action " + action);
           
               
             
              Map<String, String> generalResponse = new HashMap<>();
              
              
              String crop = request.getParameter("crop");
              String activity = request.getParameter("activity");
              String startDate = request.getParameter("startdate");
              String endDate = request.getParameter("enddate");
              String season = request.getParameter("season");
              String region = request.getParameter("region");
              String validUntil = request.getParameter("validuntil");
              
              Date start = CropUtil.strtoDate(startDate);
              Date end = CropUtil.strtoDate(endDate);
              Date until = CropUtil.strtoDate(validUntil);
              Calendar c = Calendar.getInstance();
              c.setTime(until);
              
           
              
              //test for null values here
              
              if(start.after(end))
              {
                  generalResponse.put(CropUtil.ERROR, "Start date cannot be later than End date");
                  System.out.println("Startdate later than end date");
                  request.setAttribute(CropUtil.GENERAL_RESPONSE, generalResponse);
                  CropUtil.redirect(request, response, "/addcrop.jsp");
                  return;
              }
                  
              
              if(action.equals("ADD".trim()))
              {
                  
                  
                  CropDetail cropDetail = new CropDetail();
                  cropDetail.setCrop(crop);
                  cropDetail.setActivity(activity);
                  cropDetail.setStartDate(start);
                  cropDetail.setEndDate(end);
                  cropDetail.setSeason(season);
                  cropDetail.setRegion(region);
                  cropDetail.setValidUntil(c.get(Calendar.YEAR));
                  cropDetail.setCreatedBy("ICT Challenge");
                  cropDetail.setLastModifiedBy("ICT Challenge");
                  boolean created = false;
            
                  
                  if(null!= cropDetailModel)
                   created = cropDetailModel.create(cropDetail);
                  else
                    generalResponse.put(CropUtil.ERROR,"Crop not created");
                  
                  if(created)
                  {
                     generalResponse.put(CropUtil.SUCCESS,"Crop Creation Successful");
                     System.out.println("Crop Creation  Successful");
                  }
                  else
                  {
                        generalResponse.put(CropUtil.ERROR,"Crop not created");
                        System.out.println("Crop not created");
                  }
                      
                  
                  request.setAttribute(CropUtil.GENERAL_RESPONSE, generalResponse);
                  CropUtil.redirect(request, response,"/viewcropdetails.jsp");
              }
              else
              {
                  String id = request.getParameter("id");
                  
                  //find crop
                  CropDetail cropDetail = cropDetailModel.findById(id);
                  
                  //update crop
                  cropDetail.setCrop(crop);
                  cropDetail.setActivity(activity);
                  cropDetail.setStartDate(CropUtil.strtoDate(startDate));
                  cropDetail.setEndDate(CropUtil.strtoDate(endDate));
                  cropDetail.setSeason(season);
                  cropDetail.setRegion(region);
                  cropDetail.setValidUntil(c.get(Calendar.YEAR));
                  cropDetail.setLastModifiedBy("ICT Challenge");
                  boolean created = false;
                  
                  
                 
                  
                  if (null != cropDetail) {
                      created = cropDetailModel.update(cropDetail);
                  } else {
                      generalResponse.put(CropUtil.ERROR, "Crop not updated");
                  }

                  if (created) {
                      generalResponse.put(CropUtil.SUCCESS, "Crop Update Successful");
                      System.out.println("Crop Creation  Successful");
                  } else {
                      generalResponse.put(CropUtil.ERROR, "Crop Not Updated");
                      System.out.println("Crop Not Updated");
                  }

                  request.setAttribute(CropUtil.GENERAL_RESPONSE, generalResponse);
                  CropUtil.redirect(request, response, "/viewcropdetails.jsp");
                    
                  
              }
              
              
              
               
            
            
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

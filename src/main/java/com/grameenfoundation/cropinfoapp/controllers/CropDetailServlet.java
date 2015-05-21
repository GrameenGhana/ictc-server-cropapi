/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.cropinfoapp.controllers;

import com.google.gson.JsonObject;
import com.grameenfoundation.cropinfo.manager.CropDetailManager;
import com.grameenfoundation.cropinfoapp.entities.CropDetail;
import com.grameenfoundation.cropinfoapp.models.CropDetailModel;
import com.grameenfoundation.cropinfoapp.utilities.CropUtil;
import com.grameenfoundation.cropinfoapp.utilities.FactoryId;
import com.grameenfoundation.cropinfoapp.utilities.ModelFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joseph George Davis
 */
@WebServlet(name = "CropDetailServlet", urlPatterns = {"/crops/getDetail"})
public class CropDetailServlet extends HttpServlet {
    
    private static final Logger LOGGER = Logger.getLogger(CropDetailServlet.class.getName());

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
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet CropDetailServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet CropDetailServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
            CropDetailManager cropDetailManager = new CropDetailManager();
            
            String crops = request.getParameter("crops");
            String region = request.getParameter("region");
            String currentDate = request.getParameter("date");
            
            
            LOGGER.info(crops);
            LOGGER.info(region);
            LOGGER.info(currentDate);
            
            
            
            String[] crop = crops.split(",");
           // int month = CropUtil.getMonthFromDate(currentDate);
            
           // LOGGER.log(Level.INFO, "month{0}", month);
            
            JsonObject details = cropDetailManager.cropDetailJSON(crop, region,currentDate);
            
            LOGGER.info(details.toString());
            
            out.print(details.toString());
               
        }
        
        catch(Exception e){
            
            System.out.println("eeeee" + e.getLocalizedMessage());
            e.printStackTrace();
            
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

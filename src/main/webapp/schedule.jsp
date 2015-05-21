<%-- 
    Document   : schedule
    Created on : May 11, 2015, 3:14:04 PM
    Author     : Joseph George Davis
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.grameenfoundation.cropinfoapp.entities.CropDetail"%>
<%@page import="com.grameenfoundation.cropinfoapp.models.CropDetailModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    List<CropDetail> cropDetails = new ArrayList<>();
 try{
     
    
    String[] crops = request.getParameterValues("crop");
    String region = request.getParameter("region");
    String date  = request.getParameter("schedule");
    System.out.println("Crops " + crops.length + "   " + crops[0]);
    
    
    CropDetailModel cropDetailModel = new CropDetailModel();
   // Calendar today = Calendar.getInstance();
   // int month = today.get(Calendar.MONTH)+1;
    
    for(String crop:crops)
    {
        cropDetails.add(cropDetailModel.getActivity(crop, region, date));
    }
    
 }
 catch(Exception e){
     System.out.println("no request available");
 }

%>
<!DOCTYPE html>
<html >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
        <title>Crop Schedule</title>
    </head>
    <body>
        <div class="container" style="margin-left:250px">
            <div class="row">
                <div class="col-md-8">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="panel-title" >
                                <span class="glyphicon glyphicon-grain"></span>Crop Schedule
                                <!--<a href="<%=request.getContextPath()%>/viewcropdetails.jsp" class="btn btn-info pull-right btn-sm " >View Crops</a>-->
                            </div>    
                        </div>
                            
                            <div class="panel-body" ng-app="cropschedule" ng-controller="ScheduleController">

                                    <form  class="form-horizontal" method="post"  action="<%=request.getContextPath()%>/schedule.jsp">
                                        <div class="form-group" ng-repeat="crop in crops">
                                            <label for="crop" class="col-sm-4 control-label">Crop</label>
                                            <div class="col-sm-6">   
                                                <input type="text" class="form-control" id="crop" name="crop" placeholder="Crop" required/>
                                                
                                            </div>
                                            <!--<span class="glyphicon glyphicon-plus"></span>-->
                                            <button class="add" ng-click="addNewCrop()">+</button>
                                            <button class="remove" ng-click="removeCrop()">-</button>
                                        </div>
                                        
                                        
                                        <div class="form-group">
                                            <label for="region" class="col-sm-4 control-label">Region</label>
                                            <div class="col-sm-6">   
                                                <select class="form-control"  id="region" name="region">
                                                    <option>Choose one</option>
                                                    <option>Brong Ahafo</option>
                                                    <option>Central/Southern Volta</option>
                                                    <option>Ashanti/Eastern/Northern Volta</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="schedule" class="col-sm-4 control-label">Date</label>
                                            <div class="col-sm-6">
                                                <input type ="text" class="form-control" name="schedule" id="schedule" required>
                                            </div> 
                                        </div>

                                        
                                        
                                        <div class="form-group">
                                            <label for="submit" class="col-sm-4 control-label"></label>

                                            <div class="col-sm-4">   
                                                <input type="submit" name="submit"  class="btn btn-info btn-sm btn-block" value="Submit"/>
                                            </div>

                                        </div>
                                        
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th>Crop</th>  
                                                    <th>Activity</th>   
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    if (!cropDetails.isEmpty())
                                                        for (CropDetail cropdetail : cropDetails) {
                                                %>
                                                <tr>
                                                    <%if(null!= cropdetail){%>
                                                    <td><%=cropdetail.getCrop()%></td>
                                                    <td><%=cropdetail.getActivity()%></td> 
                                                    <%} else {%>
                                                    <td>No Activity</td>
                                                    <td>No Activity</td> 
                                                    <%}%>

                                                </tr>

                                                <% }else{%>
                                                
                                                 <tr>
                                                     <td>No Details Available</td> 

                                                </tr>
                                                <%}%>
                                                
                                                
                                            </tbody>
                                        </table>
                                   </form>
                                </div>

                            
                            
                            
                    </div>
                </div>
            </div>
        </div>
                                        
                                        
                                        
    </body>
</html>

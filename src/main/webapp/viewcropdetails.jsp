<%-- 
    Document   : viewcropdetails
    Created on : Apr 15, 2015, 10:46:49 AM
    Author     : Joseph George Davis
--%>

<%@page import="com.grameenfoundation.cropinfoapp.utilities.CropUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.grameenfoundation.cropinfoapp.entities.CropDetail"%>
<%@page import="com.grameenfoundation.cropinfoapp.utilities.ModelFactory"%>
<%@page import="com.grameenfoundation.cropinfoapp.models.CropDetailModel"%>
<%@page import="com.grameenfoundation.cropinfoapp.utilities.FactoryId"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
  
       CropDetailModel cropDetailModel =  (CropDetailModel) ModelFactory.getModel(FactoryId.CROPDETAIL);
       List<CropDetail> cropDetails = null;
       
       try{
       cropDetails= cropDetailModel.findAll(); 
       }catch(Exception e)
       {
          //when cropDetailModel is empty 
       }
       
      //out.print(cropDetails.size());

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Crop Details</title>
       
    </head>
    <body>
        <div class="col-md-8" style="margin-left:250px">
            
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="glyphicon glyphicon-grain"></span>Crop Detail
                    <a href="<%=request.getContextPath()%>/addcrop.jsp" class="btn btn-info pull-right btn-sm " >Add</a>
                    <span></span>
                   
                </div>
                <div class="panel-body">
                    
                    <form class="form-horizontal">
                        
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                  
                                  <th>Crop</th>  
                                  <th>Season</th>  
                                  <th>Activity</th> 
                                  <th>Start Date</th>  
                                  <th>End Date</th> 
                                  <th>Region</th>
                                  <th>Edit</th> 
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                   if(!cropDetails.isEmpty())
                                       for (CropDetail cropdetail : cropDetails) {
                                %>
                                <tr>
                                    <input type="hidden" value="<%= cropdetail.getId()%>" id="rowid" name="rowid">
                                    <td><%=cropdetail.getCrop() %></td>
                                    <td><%=cropdetail.getSeason() %></td>
                                    <td><%=cropdetail.getActivity()%></td> 
                                    <td><%=cropdetail.getStartDate()%></td>
                                    <td><%=cropdetail.getEndDate()%></td>
                                    <td><%=cropdetail.getRegion()%></td>
                                    <td><a href="<%=request.getContextPath()%>/editcrop.jsp?key=<%= cropdetail.getId()%>" class="modifytable btn btn-info pull-right btn-sm  pull-right"> Edit</a></td>
                                </tr>
                                
                                 <% }%>
                            </tbody>
                            
                        </table>
                        
                    </form>
                    
                </div>
                
            </div>
            
        </div>
    </body>
</html>

<%-- 
    Document   : editcrop
    Created on : May 5, 2015, 12:29:08 PM
    Author     : Joseph George Davis
--%>

<%@page import="com.grameenfoundation.cropinfoapp.utilities.CropUtil"%>
<%@page import="com.grameenfoundation.cropinfoapp.entities.CropDetail"%>
<%@page import="com.grameenfoundation.cropinfoapp.utilities.FactoryId"%>
<%@page import="com.grameenfoundation.cropinfoapp.utilities.ModelFactory"%>
<%@page import="com.grameenfoundation.cropinfoapp.models.CropDetailModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
   String id = request.getParameter("key");
   
   CropDetailModel cropDetailModel = (CropDetailModel)ModelFactory.getModel(FactoryId.CROPDETAIL);
   
   CropDetail cropDetail = cropDetailModel.findById(id);
   
   System.out.println("season " + cropDetail.getSeason());
   System.out.println("activity " + cropDetail.getActivity());
   System.out.println("startmonth" + cropDetail.getStartDate());
   System.out.println("endmonth" + cropDetail.getEndDate());
   System.out.println("region" + cropDetail.getRegion());

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Crop</title>
    </head>
    <body>
         <div class="container" style="margin-left:250px">
            <div class="row">
                <div class="col-md-6">
                    <div class="panel panel-default">

                        <div class="panel-heading">
                            <div class="panel-title" >
                                <span class="glyphicon glyphicon-grain"></span>Edit Crop
                            </div>
                        </div>
                        <div class="panel-body">
                            
                            <form  class="form-horizontal"  method="POST" action="<%=request.getContextPath()%>/CropServlet">
                                <div class="form-group">
                                    <label for="crop" class="col-sm-4 control-label">Crop</label>
                                    <div class="col-sm-6">   
                                        <input type="text" class="form-control" id="crop" value="<%= cropDetail.getCrop()%>" name="crop" placeholder="Crop"/>
                                    </div>
                                </div>
                                
                                    <div class="form-group">
                                        <label for="season" class="col-sm-4 control-label">Season</label>
                                        <div class="col-sm-6">   
                                            <select class="form-control" name="season" id="season">
                                                <option>Choose one</option>
                                                <option <% if (cropDetail.getSeason().equalsIgnoreCase("First")) {%>  selected="selected" <%}%>>First</option>
                                                <option <% if (cropDetail.getSeason().equalsIgnoreCase("Second")) {%>  selected="selected" <%}%>>Second</option>
                                            </select>
                                        </div>
                                    </div>
                                
                                            <div class="form-group">
                                                <label for="activity" class="col-sm-4 control-label">Activity</label>
                                                <div class="col-sm-6">
                                                    <select class="form-control" name="activity" id="activity">
                                                        <option>Choose one</option>
                                                        <option <%if (cropDetail.getActivity().equalsIgnoreCase("sowing")) {%>  selected="selected" <%}%>>sowing</option>
                                                        <option <%if (cropDetail.getActivity().equalsIgnoreCase("growing")) {%>  selected="selected" <%}%>>growing</option>
                                                        <option <%if (cropDetail.getActivity().equalsIgnoreCase("harvesting")) {%>  selected="selected" <%}%>>harvesting</option>
                                                    </select>
                                                </div>
                                            </div>

                                        <div class="form-group">
                                            <label for="startdate" class="col-sm-4 control-label">Start Date</label>
                                            <div class="col-sm-6">
                                                <input type ="text" class="form-control" name="startdate" id="startdate" value="<%=CropUtil.getFormattedDate(cropDetail.getStartDate())%>" required>

                                            </div>
                                        </div>
                               
                                                    <div class="form-group">
                                                        <label for="enddate" class="col-sm-4 control-label">End Date</label>
                                                        <div class="col-sm-6">
                                                            <input type ="text" class="form-control" name="enddate" id="enddate" value="<%=CropUtil.getFormattedDate(cropDetail.getEndDate())%>" required>
                                                        </div>
                                                    </div>
                                
                                            <div class="form-group">
                                                <label for="region" class="col-sm-4 control-label">Region</label>
                                                <div class="col-sm-6">   
                                                    <select class="form-control"  id="region" name="region">
                                                        <option>Choose one</option>
                                                        <option <%if (cropDetail.getRegion().equalsIgnoreCase("Brong Ahafo")) {%>  selected="selected" <%}%> >Brong Ahafo</option>
                                                        <option <%if (cropDetail.getRegion().equalsIgnoreCase("Central/Southern Volta")) {%>  selected="selected" <%}%>>Central/Southern Volta</option>
                                                        <option <%if (cropDetail.getRegion().equalsIgnoreCase("Ashanti/Eastern/Northern Volta")) {%>  selected="selected" <%}%>>Ashanti/Eastern/Northern Volta</option>
                                                    </select>
                                                </div>
                                            </div>

                                        <div class="form-group">
                                            <label for="validuntil" class="col-sm-4 control-label">Valid Until</label>
                                            <div class="col-sm-6">
                                                <input type ="text" class="form-control" name="validuntil" id="validuntil" value="<%=cropDetail.getValidUntil()%>" required>
                                            </div>
                                        </div>
                              
                              
                                  <div class="form-group">
                                    <label for="submit" class="col-sm-4 control-label"></label>
                                    
                                     <div class="col-sm-4">   
                                         <input type="submit" name="submit"  class="btn btn-info btn-sm btn-block" value="Submit"/>
                                         <input type="hidden" name="action" value ="EDIT"/>
                                         <input type="hidden" name="id" value="<%=cropDetail.getId()%>" >
                                    </div>
                                    
                                </div>
                                  
                               
                            </form>

                        </div>

                    </div> 

                </div>
            </div>
        </div>
    </body>
</html>

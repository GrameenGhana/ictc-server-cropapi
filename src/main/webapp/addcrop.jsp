<%-- 
    Document   : addcrop
    Created on : May 4, 2015, 12:49:01 PM
    Author     : Joseph George Davis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Add Crop</title>
    </head>
    <body>
        
        <div class="container" style="margin-left:250px">
            <div class="row">
                <div class="col-md-6">
                    <div class="panel panel-default">

                        <div class="panel-heading">
                            <div class="panel-title" >
                               <span class="glyphicon glyphicon-grain"></span>Add Crop
                               <a href="<%=request.getContextPath()%>/viewcropdetails.jsp" class="btn btn-info pull-right btn-sm " >View Crops</a>
                            </div>    
                        </div>
                        <div class="panel-body">
                            
                            <form  class="form-horizontal"  method="POST" action="<%=request.getContextPath()%>/CropServlet">
                                <div class="form-group">
                                    <label for="crop" class="col-sm-4 control-label">Crop</label>
                                    <div class="col-sm-6">   
                                        <input type="text" class="form-control" id="crop" name="crop" placeholder="Crop" required/>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="season" class="col-sm-4 control-label">Season</label>
                                    <div class="col-sm-6">   
                                    <select class="form-control" name="season" id="season">
                                            <option>Choose one</option>
                                            <option>First</option>
                                            <option>Second</option>
                                        </select>
                                    </div>
                                </div>
                                
                                 <div class="form-group">
                                    <label for="activity" class="col-sm-4 control-label">Activity</label>
                                    <div class="col-sm-6">
                                        <select class="form-control" name="activity" id="activity">
                                            <option>Choose one</option>
                                            <option>sowing</option>
                                            <option>growing</option>
                                            <option>harvesting</option>
                                        </select>
                                    </div>
                                </div>
                                
                                 <div class="form-group">
                                    <label for="startdate" class="col-sm-4 control-label">Start Date</label>
                                    <div class="col-sm-6">
                                        <input type ="text" class="form-control" name="startdate" id="startdate" required>
                                    </div> 
                                </div>
                               
                                  <div class="form-group">
                                    <label for="enddate" class="col-sm-4 control-label">End Date</label>
                                    <div class="col-sm-6">
                                        <input type ="text" class="form-control" name="enddate" id="enddate" required>
                                    
                                    </div>
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
                                    <label for="validuntil" class="col-sm-4 control-label">Valid Until</label>
                                    <div class="col-sm-6">
                                        <input type ="text" class="form-control" name="validuntil" id="validuntil" required>
                                    </div>
                                </div>
                              
                                  <div class="form-group">
                                    <label for="submit" class="col-sm-4 control-label"></label>
                                    
                                     <div class="col-sm-4">   
                                         <input type="submit" name="submit"  class="btn btn-info btn-sm btn-block" value="Submit"/>
                                         <input type="hidden" name="action" value ="ADD"/>
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

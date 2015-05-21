<%-- 
    Document   : template
    Created on : May 4, 2015, 11:36:55 AM
    Author     : Joseph George Davis
--%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><decorator:title default="Crop Details"/></title>
         <link href="<%=request.getContextPath()%>/public/styles/css/bootstrap.min.css" rel="stylesheet">
         <link href="<%=request.getContextPath()%>/public/styles/css/main.css" rel="stylesheet">
         <link href="<%=request.getContextPath()%>/public/styles/css/AdminLTE.css" rel="stylesheet">
         <link href="<%=request.getContextPath()%>/public/styles/css/jquery-ui.css" rel="stylesheet">
         <script src="<%=request.getContextPath()%>/public/js/scripts/jquery-2.1.0.min.js" type="text/javascript"></script>
         <decorator:head/>
    </head>
    <body class="skin-blue">
         <header class="header">
            <a href="<%=request.getContextPath()%>" class="logo">Crop Schedule</a>

            <nav class="navbar navbar-static-top" role="navigation">
                <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
              
            </nav>
        </header>
        <div class="col-md-8">
            <div style="display: none" class="alert alert-danger-alt alert-dismissable" id="error">
                <span class="glyphicon glyphicon-certificate"></span>
                <button type="button" class="close" data-dismiss="alert">×</button>
                <strong>${generalResponse.error}</strong>
            </div>

            <div style="display: none" class="alert alert-success-alt alert-dismissable" id="success">
                <span class="glyphicon glyphicon-certificate"></span>
                <button type="button" class="close" data-dismiss="alert">×</button>
                <strong>${generalResponse.success}</strong>
            </div>
        </div>
        <p>
        <decorator:body/>
        </p>
   
     <script src="<%=request.getContextPath()%>/public/js/scripts/angular.min.js"></script>  
     <script src="<%=request.getContextPath()%>/public/js/scripts/bootstrap.min.js" type="text/javascript"></script>
     <script src="<%=request.getContextPath()%>/public/js/scripts/jquery-ui.min.js" type="text/javascript"></script>
    
     <script type="text/javascript">
    
     $(function() {
        var eMsg =$("#error strong").html();
        var sMsg =$("#success strong").html();
              
       // alert(sMsg);
        
        //Console.info("success message " + sMsg )
        if(eMsg.length > 1) $(".alert-danger-alt").css("display","block");
        if(sMsg.length > 1) $(".alert.alert-success-alt").css("display","block");
        
    });
    
    function appendkey(url,action){
        
        
	//var rowkey =   $("#myForm input[type='hidden']").val();
	var rowkey = document.getElementById("rowid").value;
          return window.location.href = url + "?key="+rowkey;
	
    } 
    
    
     </script>
      <script src="<%=request.getContextPath()%>/public/js/scripts/app.js" type="text/javascript"></script> 
</body>
</html>

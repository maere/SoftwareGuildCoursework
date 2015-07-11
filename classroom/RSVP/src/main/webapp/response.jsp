<%-- 
    Document   : response
    Created on : Jul 9, 2015, 3:57:50 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Response</h1>
        <a href="RSVPServlet">Home</a>
       
        <!-- this is EL-->
        Your answer was ${param.myAnswer}</br><!--  param is the parameter we are passing -->
        ${message} <!-- -->
        
        
        
    </body>
</html>

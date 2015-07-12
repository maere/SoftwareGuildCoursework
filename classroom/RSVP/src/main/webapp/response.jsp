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
        <a href="RSVPServlet">Home</a><!--the stuff below is sent from the value of the RSVP java servlet class -->
       
        <!-- this is EL, expression language - the $ and {} for replacements etc.-->
        Your answer was ${param.myAnswer}</br><!--  param is the parameter the user posted for myAnswer -->
        ${message} <!--this is the message we are returning from the if statement in RSVPServlet -->
        <!--this syntax is basic substitution in webpage -->
        
        
    </body>
</html>

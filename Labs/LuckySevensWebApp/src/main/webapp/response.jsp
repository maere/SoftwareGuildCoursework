<%-- 
    Document   : response
    Created on : Jul 11, 2015, 7:58:07 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lucky Sevens App</title>
    </head>
    <body>
        <h1>Player Results</h1>
                                    <!--don't put anything in between the link tags bc will route to error -->
        <a href="LuckySevensServlet"></a><!--the stuff below is sent from the value of the RSVP java servlet class -->
        <a href="index.jsp">Go back & Play Again</a>
        <!-- this is EL, expression language - the $ and {} for replacements etc.-->
        
        <p>
        Your bet was ${param.playerBet}</br><!--  param is the parameter the user submitted for post -->
      <!--  $-{message} - this is the message we are returning from the LuckySevensServlet -->
        </p>
        <p>
        You are broke after  ${Approlls} rolls. </br>
        
        You should have quit after ${AppPeak} rolls when you had ${AppHighDollar} dollars.
        </p>
        
        
        
    </body>
</html>

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
       
        <!-- this is EL, expression language - the $ and {} for replacements etc.-->
        
        <p>
        Your bet was ${param.playerBet}</br><!--  param is the parameter the user submitted for post -->
      <!--  $-{message} - this is the message we are returning from the LuckySevensServlet -->
        </p>
        <p>
        You are broke after  ${rolls} rolls. </br>
        
        You should have quit after ${peak} rolls when you had ${highDollar} dollars.
        </p>
        
        
        
    </body>
</html>

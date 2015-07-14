<%-- 
    Document   : response
    Created on : Jul 13, 2015, 9:50:47 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flooring Calculations</title>
    </head>
    <body>
        <h1>Results</h1>

        <h4>Your materials cost for that flooring job is:</h4>
        ${matCosts}
        <br />

        <h4>Your labor cost for installing the flooring in that room is:</h4>
        ${labor}
       
        
        <h4>and would take ${quarterHours*4} hours to complete.</h4>
        <br />

    </body>
</html>

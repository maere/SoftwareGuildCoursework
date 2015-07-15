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
        <h1>Flooring Order Estimate</h1>
        <hr>                    <!--use param.attribute when it is sohmething that was passed into the servlet via the form -->
        For a ${param.length} x ${param.width} room, with a material cost of ${param.costPerSqFt} per square foot:
        <br>
        <ul>
            <li>Your materials cost for this flooring job is: ${currentMatCost}.</li>
        <br />

        <li>Your labor cost for installing the flooring in this room is: ${currentLaborCost}.</li> 
        <br/>
        <li>Your total cost for the job is ${orderTotal} and would take ${timeToComplete} hours to complete.</li><!-- hours/4...x -->
        <br />
            
        </ul>
        
    

    </body>
</html>

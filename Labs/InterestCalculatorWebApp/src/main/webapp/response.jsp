<%-- 
    Document   : response
    Created on : Jul 12, 2015, 9:32:08 PM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Interest Results</title>
    </head>
    <body>
        <h1>Calculated Interest</h1>

        <!--This will need to accept a list of objects, and do a foreach through each param.value and c:out those with nice formatting -->


        <c:forEach var="i" items="${list}">
            
            <c:out value="The year number is: ${i.year}"></c:out><br/>
            
            <c:out value="The principal at the beginning of the year is: ${i.currentBalance}"></c:out><br/>           

            
            <c:out value="The total amount of interest earned for the year is: ${i.yearInterest}"></c:out><br/>           

            
            <c:out value="The principal at the end of the year is: ${i.endPrinciple}"></c:out><br/>
            <hr>
            
        </c:forEach>



    </body>
</html>

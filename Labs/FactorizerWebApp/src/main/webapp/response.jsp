<%-- 
    Document   : response
    Created on : Jul 12, 2015, 7:47:53 PM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factorizer Results</title>
    </head>
    <body>
        <h2>Your Factorizer Results</h2><br>
        <p>For the number ${number} there are ${numOfFactors} factors:</p>

        <!--we use c, b/c that is the prefix we identified above in our tag lib-->

        <c:forEach var="i" items="${list}">
            <c:out value="${i}"><br/></c:out>
     
            </c:forEach>
            <!--
             for (int value : factorArray) {
              System.out.println(value);
          }
          System.out.println("There are " + numFact + " factors for your number " + number);
          //return sum;
            -->

            <br/>

            <!-- this needs to be fixed: I broke it out as two methods, think it needs to stay as one-->
            <c:if test="${boolPerfect}">Congrats! You picked a perfect number.</c:if>
            <c:if test="${boolPrime}">Your number is also a prime!!</c:if>

            <br/>
            <a href="index.jsp">Go Back & try another number</a>



    </body>
</html>

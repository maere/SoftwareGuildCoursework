<%-- 
    Document   : fcresponse
    Created on : Jul 15, 2015, 8:54:01 PM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lucky Sevens</title>

        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>

    <body>

        <div class="container">

            <div class="page-header">
                <h3 class="text-center">Software Craftsmanship Guild Java Cohort</h3>
                <h4 class="text-center">JSP Multi-App Site Lab Home Page</h4>

            </div>

            <div class="navbar">
                <ul class="nav nav-tabs">
                    <!-- Generally don't want to point to a .jsp,  -->
                    <!--<li role="presentation" class="active"><a href="${pageContext.request.contextPath}/home.jsp">Home</a></li>-->
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li><!--so now the home path will resolve to an endpoint in our controller -->
                    <!--so now, will resolve to home route, could also have it resolve to homecontroller but we didn't specify that in our annotation-->
                    <li role="presentation"><a href="${pageContext.request.contextPath}/LuckySevensController">Lucky Sevens</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/FactorizerController">Factorizer</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/InterestCalcController">Interest Calculator </a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/FlooringCalcController">Flooring Calculator</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/TipCalcController">Tip Calculator</a></li>
                </ul>    
            </div>

            <!-- the main part of the original jsp page(s) will go here -->    
            <div>
                <div class="starter-template">
                      <h3>Flooring Order Estimate</h3>
                    </br>
                    <!-- <a href="LuckySevensController"></a>-->
                    <p>
                        For a ${param.length} x ${param.width} room, with a material cost of ${param.costPerSqFt} per square foot:
                    </p>
                    <ul>
                        <li>Your materials cost for this flooring job is: ${currentMatCost}.</li>
                        <br />

                        <li>Your labor cost for installing the flooring in this room is: ${currentLaborCost}.</li> 
                        <br/>
                        <li>Your total cost for the job is ${orderTotal} and would take ${timeToComplete} hours to complete.</li><!-- hours/4...x -->
                        <br />
                    </ul>

                    <form action="FlooringCalcController">
                        <button type="submit" id="add-button" class="btn btn-default" value="Play Again">Play Again</button>
                        </br>
                        </br>
                    </form>

                   


                </div>

            </div>



            <footer class="footer">
                <div class="container text-center">  
                    <p class="text-muted">
                        Created By: Mary Sweeney 2015<br/>
                        Powered By Java and Bootstrap
                    </p>
                </div>
            </footer>

        </div>

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <!--this is a relative path, part of Spring, and part of the EL framework--we can't see this -->
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

<!--
<!--above is how we tell it the name of the model we are using -->                   


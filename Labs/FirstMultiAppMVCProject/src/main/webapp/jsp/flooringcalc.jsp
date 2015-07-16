<%-- 
    Document   : flooringcalc
    Created on : Jul 15, 2015, 8:54:33 PM
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
        <title>Flooring Calculator</title>

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
                    <h3>Flooring Calculator</h3>
                    </br>
                    <p>This program estimates the cost of materials and labor for a flooring job.</p><br />

                    <sf:form action="FlooringCalcController" method="post" class="form-horizontal" role="form" modelAttribute="viewbag" >
                        <div class="form-group">
                            

                            <div class="col-md-8">
                            <!--all must be cast from strings-->
                            What is the length of the room you want to floor?<br/> <!-- float-->
                            <input type="text" name="length" />
                            <br/>
                            <br/>
                            What is the room's width?<!-- int --><br/>
                            <input type="text" name="width" />
                            <br/>
                            <br/>
                            What is the cost per square foot of your desired flooring?<br/> <!-- float-->
                            <input type="text" name="costPerSqFt" /><br/>
                            <!--the text value of name="" is what will be sent to server -->
                            <br/>
                            <button type="submit" id="add-button" class="btn btn-default">Calculate Order</button>
                            </div>
                            <!--sf errors-->
                        </div>
                    </div>
                </sf:form>
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
<!--abovve is how we tell it the name of the model we are using -->                   









<%-- 
    Document   : displayAllAddresses
    Created on : Jul 16, 2015, 12:03:28 PM
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
        <title>Display Your Addresses</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>Address Book</h1>
            <hr/>
            <!-- nav bar-->
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/createAddressForm">Add</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/searchAddresForm">Search</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayAllAddresses">List</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/editAddressForm">Edit</a></li>
                </ul>    
            </div>

            <!--main content-->


            <div class="row row-eq-height">
                <div class="col-md-6">
                    <div class="col-md-10">
                        <c:forEach var="address" items ="addressList">                         
                            <c:out value="${address.firstName}"></c:out>
                            <c:out value="${address.lastName}"></c:out>
                            <c:out value="${address.street}"></c:out> <br/>
                             <c:out value="${address.city}"></c:out>
                              <c:out value="${address.state}"></c:out>
                               <c:out value="${address.zipCode}"> </c:out>            
                        </c:forEach>

                    </div>

                </div>
                <div class="col-md-6 "><img src="img/ponytailinsidelook_720.jpg" class="img-responsive"></div>
            </div>



            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>




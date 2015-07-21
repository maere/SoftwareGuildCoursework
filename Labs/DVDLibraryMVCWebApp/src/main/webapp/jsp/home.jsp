<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DVD Library Web App</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>

        <div class="container">
<!-- header -->
            <div class="page-header">
                <h3 class="text-center">DVD Library</h3>
                <h4 class="text-center"></h4>
              
            </div>
<!-- tabbed nav links -->
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <!-- Generally don't want to point to a .jsp,  -->
                    <!--<li role="presentation" class="active"><a href="${pageContext.request.contextPath}/home.jsp">Home</a></li>-->
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li><!--so now the home path will resolve to an endpoint in our controller -->
                                                                    <!--so now, will resolve to home route, could also have it resolve to homecontroller but we didn't specify that in our annotation-->
                    <li role="presentation"><a href="${pageContext.request.contextPath}/addDvdForm">Add Title</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayDvdTitles">List</a></li>
                     <!--<li role="presentation" class="active"><a href="${pageContext.request.contextPath}/editDvdTitle">Edit</a></li>-->
                    <li role="presentation"><a href="${pageContext.request.contextPath}/searchDvdCollection">Search</a></li>

                </ul>    
            </div>

<!-- main part of page -->
            <div>
                <div class="starter-template">
                     <div class="form-group">
                            <div class="col-md-8">
                        
                                Welcome to the DVD Library. This app allows you to catalog your personal DVD collection.<br>
                                Make a selection from the menu above to start.
                        </br>

                       
                            </div>
                        </div>
                    
                </div>

            </div>


<!--footer-->
            <footer class="footer">
                <div class="container text-center"> 
                    <p class="text-muted"><br/>
                        Created By: Mary Sweeney 2015<br/>
                        Powered By Java and Bootstrap<br/>
                    </p>   
                </div>
            </footer>

        </div>


        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
         <script src="${pageContext.request.contextPath}/js/contactList.js"></script>

    </body>
</html>



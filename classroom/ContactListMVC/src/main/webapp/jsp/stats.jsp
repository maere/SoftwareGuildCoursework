<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Stats</title>
 
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    
    <body>
        
        <div class="container">
            <h1>Stats</h1>
            <hr/>
            <div class="navbar">
                 <ul class="nav nav-tabs">
                                                     <!--we want to resolve to our MVC urls..
                                                                                    nothing should refer to index.jsp anymore because we are routing--will always be a path -->
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                
                    <li role="presentation"><a href="${pageContext.request.contextPath}/search">Search</a></li>
                    <li class="active" role="presentation"><a href="${pageContext.request.contextPath}/stats">Stats</a></li>
                </ul>    
            </div>
                
            <h2></h2>
            <h3></h3><!--this is the message value from the controller -->
            
        </div>
        
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <!--this is a relative path, part of Spring, and part of the EL framework--we can't see this -->
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>



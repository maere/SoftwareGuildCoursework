<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
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
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/createAddressForm">Add</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/searchAddresForm">Search</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayAllAddresses">List</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/editAddressForm">Edit</a></li>
                </ul>    
            </div>

            <!--main content-->
            <div class="container">
                <div class="col-md-6"><img src="img/vintageaddressbook_720.jpg" class="img-responsive" alt="Responsive image" /></div>
                <div class="col-md-6"><p>Welcome to address book (like, in the old times).  But better, because it's in a computer.
                    So, like, you can add an address (while enjoying cocktails), you can update an address (nibbling on crudites), 
                    you can delete an address (for example, your old beau), 
                    or display a list so that you can sit back and reflect over a martini and remember people fondly.  
                    Nostalgia means pain from an old wound.</p></div>
           
            </div>
            
            
        <!-- now neeed a button to submit the input abouve -->

      





        </div>
<!-- Placed at the end of the document so the pages load faster -->
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>


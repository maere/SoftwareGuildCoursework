<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Company Contacts</title>
 
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    
    <body>
        
        <div class="container">
            <h1>Contact List</h1>
            <hr/>
            <div class="navbar">
                 <ul class="nav nav-tabs">
                                                     <!--we want to resolve to our MVC urls..
                                                                                    nothing should refer to index.jsp anymore because we are routing--will always be a path -->
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                
                    <li role="presentation"><a href="${pageContext.request.contextPath}/search">Search</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/stats">Stats</a></li>
                    <li class="active" role="presentation"><a href="${pageContext.request.contextPath}/displayContactListNoAjax">Contact List (No Ajax)</a></li>
                </ul>    
            </div>
                <!--we are going to pass in our contact list from the model and HomeController -->
                <div class="container">
                    <h1>Company Contacts</h1>
                    <a href="displayNewContactFormNoAjax">Add a Contact</a><!--haven't buuilt the form yet...this is a placeholder -->
                    <hr>
                    <c:forEach var="contact" items="${contactList}">
                        <!--links for list and edit, and URLs which will allow us to do that - need to build URLs in the following manner 
<!--this will be an actual URL  var name -->
                <s:url value="deleteContactNoAjax" var="deleteContact_url"><!--won't be produced on the screen, but used by other elements -->
                    <s:param name="contactId" value="${contact.contactId}"></s:param><!-- -->
                </s:url>  
                    
                    <s:url value="displayEditContactFormNoAjax" var="editContact_url">
                        <s:param name="contactId" value="${contact.contactId}"></s:param>
                    </s:url>
                    
                    
                    <c:if test="${contact.lastName=='Doe'}">CEO<br /></c:if><!--strings are in single quotes in HTML, and params are in "" -->
                                                <!--CEO will get rendered if the contact's last name is Doe -->
                    Name: ${contact.firstName} ${contact.lastName} | <!--will add one space, but not multiple -->
                    <a href="${deleteContact_url}">Delete</a> |
                    <a href="${editContact_url}">Edit</a><br/>
                    Phone: ${contact.phone}<br/>
                    Email: ${contact.email}<br/>
                    <hr>
                    
                    
                    </c:forEach>
                    
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



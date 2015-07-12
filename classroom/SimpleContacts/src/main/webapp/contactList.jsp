<%-- 
    Document   : contactList
    Created on : Jul 10, 2015, 9:35:47 AM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!--the prefix will be used below to make tags, here it stands for core -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- this is the VIEW -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact List</title>
    </head>
    <body>
        <h1>Contact List</h1>          
        <!--we use c, b/c that is the prefix we identified above in our tag lib-->
        <c:forEach var="contact" items="${contactList}"> <!--the param we passed was the contactList object we created in our servlet -->
                <!--var contact is the random variable we assign in a for each loop to hold the object temporarily -->
        <!--iterate to output the view -->
        <c:out value="${contact.name} |" ><br/></c:out>
        <c:out value="${contact.phone} |" ><br/></c:out>
        <c:out value="${contact.email}" ><br/></c:out><!--this is all JSTL, the funky bold stuff-->
        <br/>
        </c:forEach>
    </body>
</html>

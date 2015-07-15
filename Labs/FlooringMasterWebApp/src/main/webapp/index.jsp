<%-- 
    Document   : index
    Created on : Jul 13, 2015, 9:50:37 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flooring Master Web App Form</title>
    </head>
    <body>
        <h1>Flooring Master</h1>
        <p>This app will help you calculate the cost of different types installing your chosen flooring for a room.</p>
        <br />
        <form action="FlooringMasterMiniServlet" method="post"> <!-- action selections the RSVP servlet class to handle requst -->

            <!--all must be cast from strings-->
            What is the length of the room you want to floor? <!-- float-->
            <input type="text" name="length" /><br/>
            <br/>
            What is the room's width? <!-- int -->
            <input type="text" name="width" /><br/>
            <br/>
            What is the cost per square foot of your desired flooring? <!-- float-->
            <input type="text" name="costPerSqFt" /><br/>
            <br/>
            <!--the text value of name="" is what will be sent to server -->
            <br/>
            <input type="submit" value="Calculate My Order" /> <!--this is what the submit button says on it -->

        </form>

    </body>
</html>

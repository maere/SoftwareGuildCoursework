<%-- 
    Document   : index
    Created on : Jul 14, 2015, 10:24:01 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tip Calculator</title>
    </head>
    <body>
        <!--Create a program which asks the user to enter in a dollar value a
        nd the tip percentage.   -->
        <h1>Tip Calculator</h1>
        <p>This app will help you calculate the dollar value you should tip on a meal or other service.</p>
        <br />
        <form action="TipCalculatorServlet" method="post"> <!-- action selections the RSVP servlet class to handle requst -->

            <!--all must be cast from strings-->
            Enter the value of your meal or service: <!-- float-->
            <input type="number" name="amountOfService" /><br/>
            <br/>
            What percentage would you like to tip? <!-- int -->
            <input type="input" name="tipPercentage" /><br/>
            <br/>
            
            <!--the text value of name="" is what will be sent to server -->
            <br/>
            <input type="submit" value="Calculate Tip" /> <!--this is what the submit button says on it -->

        </form>
        
    </body>
</html>

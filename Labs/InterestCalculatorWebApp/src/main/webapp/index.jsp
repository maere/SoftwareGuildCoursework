<%-- 
    Document   : index
    Created on : Jul 12, 2015, 9:28:55 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interest Calculator</title>
    </head>
    <body>
        <h1>Interest Calculator</h1>
        <div class="container">

            <div class="starter-template">
                <p>This app will calculate accrued interest on a principle at any interest rate.</p>
                </br>

                <form action="InterestCalcServlet" method="post"> <!-- action selections the RSVP servlet class to handle requst -->

                    <!--all must be cast from strings-->
                    How much money will you be investing? <!-- float-->
                    <input type="text" name="moneyInvested" /><br />

                    How many years will you invest? <!-- int -->
                    <input type="text" name="yearsInvested" /><br />

                    What is your annual interest rate? <!-- float-->
                    <input type="text" name="InterestRate" /><br />

                    <!--the text value of name="" is what will be sent to server -->
                    <br />
                    <input type="submit" value="Calculate Interest" /> <!--this is what the submit button says on it -->

                </form>
            </div>





    </body>
</html>

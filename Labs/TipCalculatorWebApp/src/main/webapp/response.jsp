<%-- 
    Document   : response
    Created on : Jul 14, 2015, 10:24:13 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tip Calculator Result</title>
    </head>
    <body>
        <h1>Tip Calc Result</h1>
        Your service costing ${param.amountOfService} when tipping ${param.tipPercentage}% would require:
        <br />
        <br />
        Tip: $ ${tip}
        <br />
        Total: $ ${param.amountOfService+tip}
        
        
    </body>
</html>
<!--Then print out the subtotal along with the total plus tip (grand total). 
        Output: 
        Amount: $10.00 
        Tip %: 15 
        Tip:     $1.50 
        Total:  $11.50 
        
        -->
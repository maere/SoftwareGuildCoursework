<%-- 
    Document   : index
    Created on : Jul 12, 2015, 7:47:10 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factorizer App</title>
        
        <h1>Welcome to the Factorizer!</h1>
         <div class="container">

            <div class="starter-template">
                <p>"Please enter a number you would like to factor in the box below."</p>
                </br>

                <form action="FactorizerServlet" method="post"> <!-- action selections the RSVP servlet class to handle requst -->
               
                
                <!--this will also possibly be included whte post -->
                        Your number: <br />
                        <input type="text" name="userNum" /><br /><!--the text value of myNotes is what will be sent -->
                        <input type="submit" value="Factorize This Number" /> <!--this is what the submit button says on it -->
                        
                </form>
            </div>
        
    </head>
    <body>
        
        
        
    </body>
</html>

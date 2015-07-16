<%-- 
    Document   : index
    Created on : Jul 11, 2015, 7:57:45 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lucky Sevens Game</title>
    </head>
    <body>
        <h1>Welcome to Lucky Sevens!</h1>
         <div class="container">

            <div class="starter-template">
                <h3>"How much money do you want to bet?"</h3>
                </br>

                <form action="LuckySevensServlet" method="post">
                    <!-- action selections the RSVP servlet class to handle requst -->
                <!-- this will resolve into the URL and stands for the URL we are going to post to -->
                
                <!--this will also possibly be included whte post -->
                        Enter an integer value (whole number): <br />
                        <input type="text" name="playerBet" /><br /><!--the text value of myNotes is what will be sent -->
                        <br />
                        <input type="submit" value="Let's play!" /> <!--this is what the submit button says on it -->   
                </form>
            </div>
        
         </div>
    </body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DVD Library Web App</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>

        <div class="container">
            <!-- header -->
            <div class="page-header">
                <h3 class="text-center">DVD Library</h3>
                <h4 class="text-center"></h4>

            </div>
            <!-- tabbed nav links -->
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <!-- Generally don't want to point to a .jsp,  -->
                    <!--<li role="presentation" class="active"><a href="${pageContext.request.contextPath}/home.jsp">Home</a></li>-->
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li><!--so now the home path will resolve to an endpoint in our controller -->
                    <!--so now, will resolve to home route, could also have it resolve to homecontroller but we didn't specify that in our annotation-->
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/addDvdForm">Add Ttile</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayDvdTitles">List</a></li>
                     <!--<li role="presentation" class="active"><a href="${pageContext.request.contextPath}/editDvdTitle">Edit</a></li>-->
                    <li role="presentation"><a href="${pageContext.request.contextPath}/searchDvdCollection">Search</a></li>

                </ul>    
            </div>

            <!-- main part of page -->
            <div>                       <!--for the controller to grab the form fields needs a name="thisAttribute" in the input tag..probably should match the model -->
                <div class="starter-template">
                    <div class="form-group">
                        <div class="col-md-8">
                            <form class="form-horizontal" role="form" modelAttribute="Dvd" action="addDvdForm" method="post">

<!--why can't one use sf formm here? was throwing errors -->
                                    <div class="form-group">
                                        <label for="add-title" class="col-md-4 control-label">Title</label>
                                        <div class="col-md-8">                     
                                        <input type="text" class="form-control" name="title" id="add-title" path="title" placeholder="Film Title"></input>            
                                        
                                        </div>
                                    </div> 

                                    <div class="form-group">
                                        <label for="add-release-date" class="col-md-4 control-label">Release Date</label>
                                        <div class="col-md-8"><!--this div is just to create spacing in the grid -->   <!--this placeholder is just in case we don't have a value already  -->                       
                                        <input type="text" class="form-control" name="releaseDate" id="add-release-date" path="releaseDate" placeholder="Release Date (form must be YYYY-MM-DD)"></input>
                                            <!--now we will put in all of our errors in the view, and we will need indicate all of the "paths" - why is the param called a path?-->   
                                        

                                        </div>
                                    </div> 

                                    <div class="form-group">
                                        <label for="add-rating" class="col-md-4 control-label">MPAA Rating</label>
                                        <div class="col-md-8"><!--this div is just to create spacing in the grid -->   <!--this placeholder is just in case we don't have a value already  -->                       
                                        <input type="text" class="form-control" name="mpaaRating" id="add-rating" path="title" placeholder="MPAA Rating"></input>
                                            <!--now we will put in all of our errors in the view, and we will need indicate all of the "paths" - why is the param called a path?-->   
                                        

                                        </div>
                                    </div> 

                                    <div class="form-group">
                                        <label for="add-director" class="col-md-4 control-label">Director</label>
                                        <div class="col-md-8"><!--this div is just to create spacing in the grid -->   <!--this placeholder is just in case we don't have a value already  -->                       
                                        <input type="text" class="form-control" name="director" id="add-director" path="director" placeholder="Directed By"></input>
                                            <!--now we will put in all of our errors in the view, and we will need indicate all of the "paths" - why is the param called a path?-->   


                                        </div>
                                    </div> 

                                    <div class="form-group">
                                        <label for="add-studio" class="col-md-4 control-label">Studio</label>
                                        <div class="col-md-8"><!--this div is just to create spacing in the grid -->   <!--this placeholder is just in case we don't have a value already  -->                       
                                        <input type="text" class="form-control" name="studio" id="add-studio" path="studio" placeholder="Studio"></input>
                                            <!--now we will put in all of our errors in the view, and we will need indicate all of the "paths" - why is the param called a path?-->   
                                        

                                        </div>
                                    </div> 

                                    <div class="form-group">
                                        <label for="add-note" class="col-md-4 control-label">User Review</label>
                                        <div class="col-md-8"><!--this div is just to create spacing in the grid -->   <!--this placeholder is just in case we don't have a value already  -->                       
                                        <input type="text" class="form-control" name="note" id="add-note" path="note" placeholder="User Notes"></input>
                                           
                                        <!--now we will put in all of our errors in the view, and we will need indicate all of the "paths" - why is the param called a path?-->   
                                        <!---->

                                        </div>
                                    </div> 

                                    <!-- now neeed a button to submit the input abouve -->

                                    <div class="form-group">
                                        <div class="col-md-offset-4 col-md-8">
                                            <button type="submit" id="add-button" class="btn btn-primary">Add DVD</button>
                                        </div>
                                    </div>

                            </form>



                        </div>
                    </div>
                </div>

            </div>


            <!--footer-->
            <footer class="footer">
                <div class="container text-center"> 
                    <p class="text-muted"><br/>
                        Created By: Mary Sweeney 2015<br/>
                        Powered By Java and Bootstrap<br/>
                    </p>   
                </div>
            </footer>

        </div>


        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>



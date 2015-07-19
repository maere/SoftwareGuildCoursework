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
                    <li role="presentation"><a href="${pageContext.request.contextPath}/addDvdForm">Add Title</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayDvdTitles">List</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/editDvdTitle">Edit</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/searchDvdCollection">Search</a></li>

                </ul>    
            </div>
        </div>
        <!-- main part of page -->



        <div class="container">
            <h1>Edit Dvd</h1>

            <!--will put in a link that will reference our list -->
            <a href="displayDvdTitles">DVD List</a><br/>
            <hr/>

            <!--we are using a special form taglib -- this is the sf springform library that we added above -->
            <!-- we are using the spring library because Spring will help us pre-populate these fields with our current Data -->
            <sf:form class="form-horizontal" role="form" modelAttribute="dvd" 
                     action="editDvd" method="post">   <!--above is how we tell it the name of the model we are using -->                   
               
                <!--start here--action is the name of the route and/or method in controller (only in controller) and model attributes above to match back-- contact vs Dvd or dvd-->
                <div class="form-group">
                    <label for="add-title" class="col-md-4 control-label">Title:</label>
                    <div class="col-md-8"><!--this div is just to create spacing in the grid -->   <!--this placeholder is just in case we don't have a value already  -->                       
                        <sf:input type="text" class="form-control" id="add-title" path="title" placeholder="Title"></sf:input>
                            <!--now we will put in all of our errors in the view, and we will need indicate all of the "paths" - why is the param called a path?-->   
                        <sf:errors path="title" cssclass="error"></sf:errors>
                            <!--!!!!!! DO NOT FORGET THIS!!! we forgot to add an id to this -- should be a hidden field-- but can go anywhere bc it will not display-->                      
                        <sf:hidden path="id"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="add-release-date" class="col-md-4 control-label">Release Date:</label>
                    <div class="col-md-8"><!--this div is just to create spacing in the grid -->   <!--this placeholder is just in case we don't have a value already  -->                       
                        <sf:input type="text" class="form-control" id="add-release-date" path="releaseDate" placeholder="Release Date"></sf:input>
                        <sf:errors path="releaseDate" cssclass="error"></sf:errors>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-rating" class="col-md-4 control-label">Rating:</label>
                        <div class="col-md-8"><!--this div is just to create spacing in the grid -->   <!--this placeholder is just in case we don't have a value already  -->                       
                        <sf:input type="text" class="form-control" id="add-rating" path="mpaaRating" placeholder="Movie  Rating"></sf:input>
                        <sf:errors path="mpaaRating" cssclass="error"></sf:errors>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="add-director" class="col-md-4 control-label">Director:</label>
                        <div class="col-md-8"><!--this div is just to create spacing in the grid -->   <!--this placeholder is just in case we don't have a value already  -->                       
                        <sf:input type="text" class="form-control" id="add-director" path="director" placeholder="Director"></sf:input>
                        <sf:errors path="director" cssclass="error"></sf:errors>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-studio" class="col-md-4 control-label">Studio:</label>
                        <div class="col-md-8"><!--this div is just to create spacing in the grid -->   <!--this placeholder is just in case we don't have a value already  -->                       
                        <sf:input type="text" class="form-control" id="add-studio" path="studio" placeholder="Studio"></sf:input>
                        <sf:errors path="studio" cssclass="error"></sf:errors>

                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-user-review" class="col-md-4 control-label">User Review:</label>
                        <div class="col-md-8"><!--this div is just to create spacing in the grid -->   <!--this placeholder is just in case we don't have a value already  -->                       
                        <sf:input type="text" class="form-control" id="add-userReview" path="userReview" placeholder="User Review"></sf:input>
                        <sf:errors path="userReview" cssclass="error"></sf:errors>

                        </div>
                    </div>

                    <!-- now neeed a button to submit the input abouve -->

                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button type="submit" id="add-button" class="btn btn-primary">Edit DVD</button>
                        </div>
                    </div>


            </sf:form>


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




        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>



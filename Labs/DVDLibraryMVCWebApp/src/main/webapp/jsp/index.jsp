<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DVD Library Ajax Web App</title>
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
      <h1 class="text-center">DVD Library</h1>
      <br/>
      <p> Welcome to the DVD Library. This app allows you to catalog your personal DVD collection.</p>
   </div>

<!-- tabbed nav links -->
<div class="navbar">
                <ul class="nav nav-tabs">   
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/index">Index</a></li><!--so now the home path will resolve to an endpoint in our controller -->
                  <!--so now, will resolve to home route, could also have it resolve to homecontroller but we didn't specify that in our annotation-->
                    <li role="presentation"><a href="${pageContext.request.contextPath}/search">Search</a></li>
                </ul>    
</div>


<!-- removed tab links for ajax version-->
<div class="row">
   <div class="col-md-6">
      <h4>My DVDs</h4>
      <table id="dvdTable" class="table table-hover">
         <thead>
            <tr>
               <th width="40%">Title</th>
               <th width="30%">Director</th>
               <th width="15%"></th>
               <th width="15%"></th>
            </tr>
         </thead>
         <tbody id="contentRows"></tbody>
      </table>
   </div>
   <!-- main part of page -->
   <div class="col-md-6">
      <h4> Add a DVD</h4>
      <form class="form-horizontal" role="form">
         <div class="form-group">
            <label for="add-title" class="col-md-4 control-label">Title</label>
            <div class="col-md-6">                     
               <input type="text" class="form-control" name="title" id="add-title" path="title" placeholder="Film Title"/>          
            </div>
         </div>
         <div class="form-group">
            <label for="add-releaseDate" class="col-md-4 control-label">Release Date</label>
            <div class="col-md-6"<!--this div is just to create spacing in the grid -->   <!--this placeholder is just in case we don't have a value already  -->                       
            <input type="text" class="form-control" name="releaseDate" id="add-releaseDate" path="releaseDate" placeholder="Release Date (form must be YYYY-MM-DD)"/>
            <!--now we will put in all of our errors in the view, and we will need indicate all of the "paths" - why is the param called a path?-->   
         </div>
   </div>
   <div class="form-group">
   <label for="add-rating" class="col-md-4 control-label">MPAA Rating</label>
   <div class="col-md-6"><!--this div is just to create spacing in the grid -->   <!--this placeholder is just in case we don't have a value already  -->                       
   <input type="text" class="form-control" name="mpaaRating" id="add-rating" path="title" placeholder="MPAA Rating"/>
   <!--now we will put in all of our errors in the view, and we will need indicate all of the "paths" - why is the param called a path?-->   
   </div>
   </div> 
   <div class="form-group">
   <label for="add-director" class="col-md-4 control-label">Director</label>
   <div class="col-md-6"><!--this div is just to create spacing in the grid -->   <!--this placeholder is just in case we don't have a value already  -->                       
   <input type="text" class="form-control" name="director" id="add-director" path="director" placeholder="Directed By"/>
   <!--now we will put in all of our errors in the view, and we will need indicate all of the "paths" - why is the param called a path?-->   
   </div>
   </div> 
   <div class="form-group">
   <label for="add-studio" class="col-md-4 control-label">Studio</label>
   <div class="col-md-6"><!--this div is just to create spacing in the grid -->   <!--this placeholder is just in case we don't have a value already  -->                       
   <input type="text" class="form-control" name="studio" id="add-studio" path="studio" placeholder="Studio"/>
   <!--now we will put in all of our errors in the view, and we will need indicate all of the "paths" - why is the param called a path?-->   
   </div>
   </div> 
   <div class="form-group">
   <label for="add-note" class="col-md-4 control-label">User Review</label>
   <div class="col-md-6"><!--this div is just to create spacing in the grid -->   <!--this placeholder is just in case we don't have a value already  -->                       
   <input type="text" class="form-control" name="note" id="add-note" path="note" placeholder="User Notes"/>
   <!--now we will put in all of our errors in the view, and we will need indicate all of the "paths" - why is the param called a path?-->   
   <!---->
   </div>
   </div> 
   <!-- now neeed a button to submit the input abouve -->
   <div class="form-group">
   <div class="col-md-offset-2 col-md-6">
   <button type="submit" id="add-button" class="btn btn-primary">Add DVD</button>
   </div>
   </div>
   </form>
      
   <div id="validationErrors" style="color: red"/>   
      
      
</div>
</div>
<!-- end main part of page -->
</div>
<!-- Details Modal -->
<div class="modal fade" id="detailsModal" tabindex="-1" role="dialog"
   aria-labelledby="detailsModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">
            <span aria-hidden="true">&times;</span>
            <span class="sr-only">Close</span>
            </button>
            <h4 class="modal-title" id="detailsModalLabel">Movie Stats</h4>
         </div>
         <div class="modal-body">
<!---->            <h3 id="dvd-id"></h3><!--is this kosher, or should it just be "id" -->
            <table class="table table-bordered">
               <tr>
                  <th>Title</th>
                  <td id="dvd-title"></td>
               </tr>
               <tr>
                  <th>Release Date</th>
                  <td id="dvd-releaseDate"></td>
               </tr>
               <tr>
                  <th>Rated</th>
                  <td id="dvd-rating"></td>
               </tr>
               <tr>
                  <th>Director</th>
                  <td id="dvd-director"></td>
               </tr>
               <tr>
                  <th>Studio</th>
                  <td id="dvd-studio"></td>
               </tr>
               <tr>
                  <th>Note</th>
                  <td id="dvd-note"></td>
               </tr>
            </table>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">
            Close
            </button>
         </div>
      </div>
   </div>
</div>
<!-- end details modal -->
<!-- edit modal -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="detailsModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">
            <span aria-hidden="true">&times;</span>
            <span class="sr-only">Close</span>
            </button>
            <h4 class="modal-title" id="detailsModalLabel">Edit DVD</h4>
         </div>
         <div class="modal-body">
            <h3 id="dvd-id"></h3><!--this doesn't do anything except display the id # on the modal view -->
            <form class="form-horizontal" role="form">
               <div class="form-group">
                  <label for="edit-title" class="col-md-4 control-label">Title</label>
                  <div class="col-md-8">
                     <input type="text" class="form-control" id="edit-title" placeholder="Film Title" />
                  </div>
               </div>
               <div class="form-group">
                  <label for="edit-releaseDate" class="col-md-4 control-label">Released</label>
                  <div class="col-md-8">
                     <input type="text" class="form-control" id="edit-releaseDate" placeholder="Released (YYYY-MM-DD)" />
                  </div>
               </div>
               <div class="form-group">
                  <label for="edit-rating" class="col-md-4 control-label">Rating</label>
                  <div class="col-md-8">
                     <input type="text" class="form-control" id="edit-rating" placeholder="Film Rating" />
                  </div>
               </div>
               <div class="form-group">
                  <label for="edit-director" class="col-md-4 control-label">Director</label>
                  <div class="col-md-8">
                     <input type="text" class="form-control" id="edit-director" placeholder="Director" />
                  </div>
               </div>
               <div class="form-group">
                  <label for="edit-studio" class="col-md-4 control-label">Studio</label>
                  <div class="col-md-8">
                     <input type="text" class="form-control" id="edit-studio" placeholder="Studio" />
                  </div>
               </div>
               <div class="form-group">
                  <label for="edit-note" class="col-md-4 control-label">Notes</label>
                  <div class="col-md-8">
                     <input type="text" class="form-control" id="edit-note" placeholder="Notes" />
                  </div>
               </div>
               <div class="form-group">
                  <div class="col-md-offset-4 col-md-8"> <!--why does it need an id for both? one for hte button, one for the form? or edit-dvd-method? -->
                     <button type="submit" id="edit-button" class="btn btn-default" data-dismiss="modal">Edit DVD Data</button>
                     <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                     <input type="hidden" id="edit-dvd-id" /><!--this hidden button is what allows us to send this info to the server and allows us to grab the object to edit -->
                  </div>
               </div>
            </form>
         </div>
      </div>
   </div>
</div>
</div>
<!-- end edit modal -->
<!-- validation goes here-->    
<!--end validation-->    
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
<script src="${pageContext.request.contextPath}/js/dvdList.js"></script>

</body>
</html>



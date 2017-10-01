<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Radio search</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
.col-md-1, .col-md-2, .col-md-3, .col-md-4, .col-md-6, .col-md-8 {
background-color: white;
color: black;
line-height: 5em;
border: 1px solid white;
height: 5em;
}
</style>

</head>

<body>
<!-- jQuery (necessary for Bootstrap’s JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

<div class="container">
<div class="row">
	<div class="col-md-2">
	<a href="/RadioDatabaseWebApp/index.jsp">Home</a>
	</div>
	<div class="col-md-2">
	<a href="/RadioDatabaseWebApp/radio?searchAction=searchGenre">Musical genres</a>
	</div>
	<div class="col-md-8">
	<% Date date = new Date(); out.print( "Internet radio database " + date.toString());%>
	</div>
	</div> <!--  first row -->
	
	<div class = "row">
	<div class = "col-md-12">
	<form action="/RadioDatabaseWebApp/radio" class="navbar-form navbar-center" role="search" method="get">
	<div class="form-group">
	<!--Search Form -->
	<input type="hidden" id="searchAction" name="searchAction" value="searchByName" />
	<input type="text" name="radioName" id="radioName" class="form-control" required="required" placeholder="Type the Name of radio to search"/>                    
    <button type="submit" class="btn btn-default">Search</button>
    </div>
 	</form>    
           
 	<!--Radio List-->                        
 	<c:choose>
    	<c:when test="${not empty radioDescList}">
        	<table  class="table table-striped table-bordered">
             	<thead>
                <tr>
                <td>#</td>
                <td>Name</td>
                <td>Genre</td>
                <td>Url</td>                               
                </tr>
                </thead>
          <c:forEach var="radio" items="${radioDescList}">
                <tr class="info">
               	<td>${radio.id}</td>
                <td>${radio.name}</td>
                <td>${radio.genre}</td>
                <td><a href="${radio.url}">${radio.name}</a></td> 
                </tr>
          </c:forEach>               
          </table>  
        </c:when>                    
        <c:otherwise>
             	<br/>           
                 <div class="alert alert-info">
                 No data found matching your search criteria
                 </div>
       </c:otherwise>
	</c:choose>

	</div ><!-- col-->
	</div ><!-- second row -->
</div > <!-- /.container -->

</body>
</html>

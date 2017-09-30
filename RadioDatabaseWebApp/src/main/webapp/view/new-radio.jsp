<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 <link rel="stylesheet" href="css/bootstrap.min.css"/>         
<script src="js/bootstrap.min.js"></script>  
<title>Radio database</title>
</head>
 <body>
 <nav class="navbar navbar-default">
   <div class="container-fluid row">
     <div class="nav navbar-nav" id="main-navbar">
      	<a class="nav-item active" href="/RadioDatabaseWebApp/index.jsp">Home</a>
      	<a class="nav-item" href="./view/list-radios.jsp">Search</a>
      	<a class="nav-item" href="./view/new-radio.jsp">Insert</a>
      	<a class="nav-item" href="./view/list-genres.jsp">Genres</a>
    </div>
  </div>
</nav>          
 	<div class="container">
    	<h2>Radios</h2>
    	<!--Search Form -->
        <form action="/RadioWdatabaseWebApp/radio" method="get">
        	<input type="hidden" id="searchAction" name="searchAction" value="searchByName" />
            <div class="form-group col-xs-5">
            	<input type="text" name="radioName" id="radioName" class="form-control" required="required" placeholder="Type the Name of radio to search"/> 
            	<input type="text" name="radioGenre" id="radioGenre" class="form-control" required="required" placeholder="Type the Name of radio to search"/>  
            	<input type="text" name="radioUrl" id="radioUrl" class="form-control" required="required" placeholder="Type the Name of radio to search"/>                  
            </div>
          	<button type="submit" class="btn btn-info">
            <span class="glyphicon glyphicon-search"></span> Search
            </button>
            <br></br>
            <br></br>
    	</form>           
   </div>
</body>
</html>

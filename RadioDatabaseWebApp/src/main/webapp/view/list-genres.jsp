<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 <link rel="stylesheet" href="css/bootstrap.min.css"/>         
<script src="js/bootstrap.min.js"></script>  
<title>Radio database - list radio</title>
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
    	<h2>Genres</h2>
    	<!--Search Form -->
        <form action="/RadioDatabaseWebApp/radio" method="get">
        	<input type="hidden" id="searchAction" name="searchAction" value="searchGenre" />
			<p>Press button to list genres</p>
          	<button type="submit" class="btn btn-info">
            	<span class="glyphicon glyphicon-search"></span> Search Genres
            </button>
            <br></br>
    	</form>           
 	      
        <!--Genre List-->                        
         	<c:choose>
            	<c:when test="${not empty genreList}">
                	<table  class="table table-striped table-bordered">
                    	<thead>
                        	<tr>
                            	<td>#</td>
                                <td>Genre</td>                              
                           	</tr>
                        </thead>
                        <c:forEach var="genre" items="${genreList}">
                        	<tr class="info">
                            	<td>${genre.id}</td>
                               	<td>${genre.genre}</td>
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
   </div>
</body>
</html>

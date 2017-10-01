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
	<a href="/index.jsp">Home</a>
	</div>
	<div class="col-md-2">
	<a href="/view/list-genres.jsp.jsp">Musical genres</a>
	</div>
	<div class="col-md-8">
	<% Date date = new Date(); out.print( "Internet radio database " + date.toString());%>
	</div>
	</div> <!--  first row -->
	
	<div class = "row">
	<div class = "col-md-12">
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
   </div> <!--  col -->
   </div> <!--  second row -->
   </div> <!--  container  -->
</body>
</html>

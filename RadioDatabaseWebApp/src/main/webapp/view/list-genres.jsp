<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Radio search</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<!-- jQuery (necessary for Bootstrap’s JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
      
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

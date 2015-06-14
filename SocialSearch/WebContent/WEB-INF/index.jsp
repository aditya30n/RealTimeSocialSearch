<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
  <title>Social Search</title>  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <div class="jumbotron">
    <h1>Real Time Social Search</h1>
    <p>Enter the keyword to search over different social media!</p><br/>
    
    <form class="form-inline" action = "/SocialSearch/" method = "post">
    <div class="form-group">          
      <input type="text" class="form-control input-lg" style="width: 600px;" id="usr" name="searchKeyword" placeholder="Enter search keyword">      
    </div>&nbsp;
    <button type="submit" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-search"></span> Search</button>
    </form>
   
  </div>
  

    
  <div class="row">
    <div class="col-sm-4 well">
    <span class="social social-facebook"></span>
      <h3>Facebook</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
    </div>
    <div class="col-sm-4 well ">
      <h3>Twitter</h3>
      <c:choose>
		  <c:when test="${twitter == null}">
		    ...
		  </c:when>	
		  <c:otherwise>
		     <c:forEach items="${twitter}" var="festival">  
	      		<hr style=" border:none; border-top:1px dotted #f00; color:#fff; background-color:#fff; height:1px; width:100%;">     
	        	<p>${festival.getText()}</p>         		
	  		</c:forEach>
		  </c:otherwise>
		</c:choose>
      
     
      
    </div>
    <div class="col-sm-4 well ">
      <h3>Reddit</h3>        
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
    </div>
  </div>
</div>

</body>
</html>

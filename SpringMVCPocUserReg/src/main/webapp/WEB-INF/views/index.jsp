<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>User Registry</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="/resources/css/style.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script type="text/javascript" src="/resources/js/app.js"></script>
    </head>
<body>
	<h1>User Registery - MVC web application</h1>
	  <div class="row">
	    <div class="col-sm-12">
		    <form action="getbyname" method="post" onsubmit="return validate()">
		        Enter First Name : <input id="name" name="name"><input type="submit" value="Search">
		    </form>
	    </div>
	    <br>
	    <div class="col-sm-12">
		          <a class="text-primary" href="/getall">Show All Users</a>
	    </div>
	  </div>

</body>
</html>
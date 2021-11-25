<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

 <head>        
     <title>Calculator</title>
     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">         
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 </head>
<body>
<h2 align="left" class="text-primary">Enter the numbers</h2>
<form action="/calculate" method="post">
Value 1 :<input id="num1" number="text" name="num1"><br><br>
Value 2 :<input id="num2" number="text" name="num2"><br><br>
<input type="submit" name="add" value="Add">
<input type="submit" name="sub" value="Substract">
<input type="submit" name="mul" value="Multiply">
<input type="submit" name="div" value="Divide">
</form>

</body>
</html>
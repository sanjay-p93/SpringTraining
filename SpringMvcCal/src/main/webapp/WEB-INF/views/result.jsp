<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>        
        <title>Result</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">         
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 
    </head>
    <body>
        <div>
        <h2 align="left" class="text-primary">
        	${result.message}
        	<fmt:formatNumber type="number" maxFractionDigits="2" value="${result.value}"/>
        </h2>
<br>
<a href="/Index">Back</a>
 </div>        
    </body>
</html>
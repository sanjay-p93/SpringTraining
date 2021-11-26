<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>        
        <title>User Registry</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h2 align="left" class="text-primary">Users</h2>
            <a class="float-right" href="/"><span class="text-primary">back</span></a>
            <br>
            <c:if test="${empty list}"><h4 class="text-danger">No users found.</h4></c:if>
            <c:if test="${fn:length(list) > 0}">
            <table class="table" align="center">
                <thead>
                  <tr>
                    <th>Id</th>
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th>Email</th>
                    <th>Age</th>
                  </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${list}">
                      <tr>
                        <td>${user.id}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td> 
                        <td>${user.email}</td> 
                        <td>${user.age}</td> 
                      </tr>
                    </c:forEach>
                </tbody>
              </table>  
            
            </c:if>
        </div>        
    </body>
</html>
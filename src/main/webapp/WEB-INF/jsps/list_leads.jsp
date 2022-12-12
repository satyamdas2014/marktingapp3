<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>All Leads</h2>
<table>
<tr>
<th>FirstName</th>
<th>lastName</th>
<th>Email</th>
<th>Mobile</th>
<th>Delete</th>
<th>Update</th>
<c:forEach var="leads" items="${leads}">

<tr>
<td>${ leads.firstName}</td>
<td>${ leads.lastName}</td>
<td>${ leads.email}</td>
<td>${ leads.mobile}</td>
<td><a href="delete?id=${ leads.id}">delete</a></td>
<td><a href="update?id=${ lead.id}">update</a></td>
</tr>

</c:forEach>

</table>
</body>
</html>
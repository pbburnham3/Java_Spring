<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TVDB Dashboard</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<h2>Logged in as: <c:out value="${user.userName}"></c:out>.</h2>
	<a href="/logout">Logout</a>
	
	<table class="table">
			<thead>
				<tr>
					<th scope="col">Title</th>
					<th scope="col">Description</th>
					<th scope="col">Network</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var ="oneShow" items="${shows}">
				<tr>
					<td> <a href="/dashboard/${oneShow.id}"> <c:out value="${oneShow.title }"/> </a> </td>
					<td> <c:out value="${oneShow.description }"/> </td>
					<td> <c:out value="${oneShow.network }"/> </td>
				</tr>
			</c:forEach>
				<tr>
					<td><a href="/dashboard/new">Add Show</a></td>
				</tr>
			</tbody>
	</table>

</body>
</html>
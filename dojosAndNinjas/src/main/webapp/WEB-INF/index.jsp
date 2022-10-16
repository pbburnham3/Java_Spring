<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojos</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="style.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<h1>Dojo Locations:</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Location:</th>
				<th scope="col">Ninjas:</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dojo" items="${dojos}">
				<tr>
					<td><c:out value="${dojo.name}"></c:out></td>
					<td><a href="/dojos/${dojo.id}">View Dojo</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td><a href="/dojos/new">Add a New Dojo</a></td>
				<td><a href="/ninjas/new">Add a New Ninja</a></td>
			</tr>
		</tbody>
	</table>

</body>
</html>
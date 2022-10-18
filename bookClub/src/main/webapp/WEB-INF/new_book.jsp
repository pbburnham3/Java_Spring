<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="style.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<h1>Add New Book</h1>

	<form:form action="/dashboard/new" method="POST" modelAttribute="book">
		<form:label path="title">Title:</form:label>
		<form:input type="text" path="title" />
		<form:label path="author">Author:</form:label>
		<form:input type="text" path="author" />
		<form:label path="description">Description:</form:label>
		<form:input type="textarea" path="description" />
		
		<form:input type="hidden" path="user" value="${userId}" />

		<input type="submit" value="Add Book">
	</form:form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Show</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<h1>Edit show:</h1>
	<form:form action="/dashboard/${show.id}" method="POST"
		modelAttribute="show">
		
		<input type="hidden" name="_method" value="POST">

		<form:label path="title">Title:</form:label>
		<form:errors path="title" class="text-danger" />
		<form:input type="text" path="title" />

		<form:label path="network">Network:</form:label>
		<form:errors path="network" class="text-danger" />
		<form:input type="text" path="network" />

		<form:label path="description">Description:</form:label>
		<form:errors path="description" class="text-danger" />
		<form:input type="textarea" path="description" />

		<form:input type="hidden" path="user" value="${userId}" />

		<input type="submit" value="Submit" />
	</form:form>

</body>
</html>
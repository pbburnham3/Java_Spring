<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login/Register</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="style.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<h2>REGISTER:</h2>

	<form:form action="/register" method="POST" modelAttribute="newUser">
		<form:label path="userName">Username:</form:label>
		<form:errors path="userName" class="text-danger"/>
		<form:input type="text" path="userName" />
		<form:label path="email">Email:</form:label>
		<form:errors path="email" class="text-danger"/>
		<form:input type="text" path="email" />
		<form:label path="password">Password:</form:label>
		<form:errors path="password" class="text-danger"/>
		<form:input type="text" path="password" />
		<form:label path="confirm">Confirm Password:</form:label>
		<form:errors path="confirm" class="text-danger"/>
		<form:input type="text" path="confirm" />

		<input type="submit" value="Submit">
	</form:form>


	<h2>LOGIN:</h2>

	<form:form action="/login" method="POST" modelAttribute="newLogin">
		<form:label path="email">Email</form:label>
		<form:errors path="email" class="text-danger"/>
		<form:input type="text" path="email" />
		<form:label path="password">Password:</form:label>
		<form:errors path="password" class="text-danger"/>
		<form:input type="text" path="password" />

		<input type="submit" value="Login">
	</form:form>

</body>
</html>
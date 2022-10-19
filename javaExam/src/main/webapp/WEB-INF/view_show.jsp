<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${show.title}"></c:out></title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="style.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<h3>Title:</h3>
	<h3><c:out value="${show.title }"/></h3>
	
	<h3>Network:</h3>
	<h3><c:out value="${show.network }"/></h3>
	
	<h3>Description:</h3>
	<h3><c:out value="${show.description }"/></h3>
	
	<h3>Uploaded by:</h3>
	<h3><c:out value="${show.user.userName }"/></h3>
	
	<a href="/dashboard/${show.id}/edit"> Edit: <c:out value="${show.title }"/> </a>
	
	<form action="/dashboard/${show.id }/delete" method="POST">
		     <input type="hidden" name="_method" value="delete">     
		<input type="submit" value="Delete ${show.title }">
	</form>

</body>
</html>
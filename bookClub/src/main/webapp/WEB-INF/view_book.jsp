<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${book.title}"></c:out></title>
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
	<h3><c:out value="${book.title }"/></h3>
	
	<h3>Author:</h3>
	<h3><c:out value="${book.author }"/></h3>
	
	<h3>Description:</h3>
	<h3><c:out value="${book.description }"/></h3>
	
	<h3>Uploaded by:</h3>
	<h3><c:out value="${book.user.userName }"/></h3>

</body>
</html>
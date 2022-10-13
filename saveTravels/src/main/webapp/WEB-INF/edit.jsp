<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SaveTravels Edit Item</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<h1>Edit item:</h1>
	<form:form action="/expenses/${expense.id}" method="post" modelAttribute="expense">
	    <input type="hidden" name="_method" value="put">
	    <p>
	        <form:label path="item">New item name:</form:label>
	        <form:errors path="item" class="text-danger"/>
	        <form:input path="item"/>
	    </p>
	    <p>
	        <form:label path="vendor">New vendor name:</form:label>
	        <form:errors path="vendor" class="text-danger"/>
	        <form:input path="vendor"/>
	    </p>
	    <p>
	        <form:label path="amount">New price:</form:label>
	        <form:errors path="amount" class="text-danger"/>     
	        <form:input path="amount"/>
	    </p>    
	    <input type="submit" value="Submit"/>
	</form:form>

</body>
</html>
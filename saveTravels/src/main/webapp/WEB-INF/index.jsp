<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SaveTravels</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<h1>SaveTravels!</h1>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">#ID</th>
				<th scope="col">Item Name</th>
				<th scope="col">Vendor Name</th>
				<th scope="col">Price</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var ="oneExpense" items="${expenses}">
			<tr>
				<td> <c:out value="${oneExpense.id }"/> </td>
				<td> <a href="unknown"> <c:out value="${oneExpense.item }"/> </a> </td>
				<td> <c:out value="${oneExpense.vendor }"/> </td>
				<td> <c:out value="${oneExpense.amount }"/> </td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<form:form action="/expenses" method="post" modelAttribute="expense">
	    <p>
	        <form:label path="item">Item name:</form:label>
	        <form:errors path="item" class="text-danger"/>
	        <form:input path="item"/>
	    </p>
	    <p>
	        <form:label path="vendor">Vendor name:</form:label>
	        <form:errors path="vendor" class="text-danger"/>
	        <form:textarea path="vendor"/>
	    </p>
	    <p>
	        <form:label path="amount">Price:</form:label>
	        <form:errors path="amount" class="text-danger"/>
	        <form:input path="amount"/>
	    </p>    
	    <input type="submit" value="Submit"/>
	</form:form>    

</body>
</html>
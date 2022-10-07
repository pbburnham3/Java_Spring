<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Books</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<!--  -link rel="stylesheet" href="style.css"/-->
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>

<div class="pageFlex">

	<div class="c1"></div>
	
	<div class="c2">
	
		<p class="h1">Books!</p>
		
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#ID</th>
					<th scope="col">Title</th>
					<th scope="col">Description</th>
					<th scope="col">Language</th>
					<th scope="col"># of Pages</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var ="oneBook" items="${books}">
				<tr>
					<td> <c:out value="${oneBook.id }"/> </td>
					<td> <a href="unknown"> <c:out value="${oneBook.title }"/> </a> </td>
					<td> <c:out value="${oneBook.description }"/> </td>
					<td> <c:out value="${oneBook.language }"/> </td>
					<td> <c:out value="${oneBook.numberOfPages }"/> </td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
	</div>
	
	<div class="c3"></div>

</div>

</body>
</html>
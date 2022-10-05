
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji Form</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="style.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<div class="pageFlex">

	<div class="c1"></div>

	<div class="c2">
		<h3>
			Omikuji
			<small class="text-muted">Form</small>
		</h3>
		
		<form action = "/submit" method = "POST">
		
			<label for="formControlInput" class="form-label">Enter a number between 5 and 25:</label>
			<input type="number" class="form-control" id="formControlInput" placeholder="1" name="numberInput">
			
			<label for="formControlInput" class="form-label">Enter the name of any city:</label>
			<input type="text" class="form-control" id="formControlInput" placeholder="Seattle" name="cityInput">
			
			<label for="formControlInput" class="form-label">Enter the name of any person:</label>
			<input type="text" class="form-control" id="formControlInput" placeholder="Lebron James" name="personInput">
			
			<label for="formControlInput" class="form-label">Enter a profession:</label>
			<input type="text" class="form-control" id="formControlInput" placeholder="Boat captain" name="professionInput">
			
			<label for="formControlInput" class="form-label">Enter the name of any living thing:</label>
			<input type="text" class="form-control" id="formControlInput" placeholder="Cat" name="livingInput">
			
			<label for="formControlInput" class="form-label">Say something nice to someone!</label>
			<input type="text" class="form-control" id="formControlInput" placeholder="Looking good" name="niceInput">
			
			<button type="submit" class="btn btn-primary">Submit</button>
			
		</form>
	</div>
	
	<div class="c3"></div>

</div>

</body>
</html>
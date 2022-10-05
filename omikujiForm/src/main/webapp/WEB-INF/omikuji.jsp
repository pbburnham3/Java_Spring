
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji Result</title>
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
			<div class="card">
				<div class="card-body">
					In <c:out value="${numberInput}"/> years, you will live in <c:out value="${cityInput}"/> with <c:out value="${personInput}"/> as your roommate, working as a <c:out value="${professionInput}"/>. The next time you see a <c:out value="${livingInput}"/>, you will have good luck. Also, <c:out value="${niceInput}"/>.
				</div>
			</div>
		</div>
			
		<div class="c3"></div>
		
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Welcome</title>
		<link href="css/welcome.css" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="regNavPages.jsp" />
		
		<a href="register">
			<button id="register" type="button">Register</button>
		</a>
		
		<a href="login">
			<button id="login" type="button">Log In</button>
		</a>

		<jsp:include page="footer.jsp"/>
	</body>
</html>
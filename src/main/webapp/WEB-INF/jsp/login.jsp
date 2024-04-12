<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		<link href="css/register.css" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="regNavPages.jsp" />
		
		<h1 style="text-align: center">Login</h1>
		
		<div class="formContainer">
			<form>
				<input type="text" id="email" name="email" placeholder="Email address">
				<input type="text" id="pwd" name="pwd" placeholder="Password">
				
				<input type="submit" value="Submit">
				
			</form>
		</div>

		<jsp:include page="footer.jsp"/>
	</body>
</html>
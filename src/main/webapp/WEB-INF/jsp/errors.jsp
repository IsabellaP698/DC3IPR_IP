<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Error</title>
		<link href="css/pageStyles.css" rel="stylesheet">
	</head>
	<body>
	<% request.setAttribute("pageTitle", "Errors"); %>
		<% request.setAttribute("image", "img/profileIcon.png"); %>
		
        <jsp:include page="navPages.jsp" />
		<h1 style="text-align: center">SOMETHING WENT WRONG!</h1>
		<div class="pages" style="text-align: center">
			Sorry, your process could not be processed. Please try again later!
		</div>
		<div style="text-align: center">
			<a href="welcome">Back to the Welcome Page</a>
  		</div>
	</body>
</html>
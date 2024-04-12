<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Courses</title>
	</head>
	<body>
	
		<% request.setAttribute("pageTitle", "Courses"); %>
		<% request.setAttribute("image", "img/profileIcon.png"); %>
		
        <jsp:include page="navPages.jsp" />

		<main>
			
			<jsp:include page="courseSearch.jsp"/>
		
		</main>
	
		<jsp:include page="footer.jsp"/>
		
	</body>
</html>
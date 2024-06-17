<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Course Details</title>
	</head>
	<body>
	
		<% request.setAttribute("pageTitle", "Course Details"); %>
		<% request.setAttribute("image", "img/profileIcon.png"); %>
		<% request.setAttribute("link", "profile"); %>
		
        <jsp:include page="navPages.jsp" />
        
        <main>
			
			<jsp:include page="courseDetails.jsp"/>
		
		</main>
        
        <jsp:include page="footer.jsp"/>

	</body>
</html>
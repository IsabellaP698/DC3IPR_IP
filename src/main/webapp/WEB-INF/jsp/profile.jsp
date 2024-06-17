<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Profile</title>
		<link href="css/profile.css" rel="stylesheet">
		<script type="text/javascript" src="js/profilePage.js"></script>
		
	</head>
	<body onload="loadProfilePage()">
		<% request.setAttribute("pageTitle", "Profile"); %>
		<% request.setAttribute("image", "img/courseIcon.png"); %>
		<% request.setAttribute("link", "courses"); %>
		
        <jsp:include page="navPages.jsp" />
		<main>
		
		
			<div class="row">
			
				<!-- employee bio -->
				<div class="columnP">
					<div class="bio">
					
					</div>
				
				</div>
				
				<!-- Current courses with status bar (inc. interested) -->	
				<div class="columnP">
					<div class="currentCourses">
					
					</div>
				</div>
		
			</div>
			
			<!-- Completed courses -->
			<div class="row">
				<div class="completedCourses">
					
				</div>
			</div>
		
		</main>
		
		<jsp:include page="footer.jsp"/>
		
	</body>
</html>
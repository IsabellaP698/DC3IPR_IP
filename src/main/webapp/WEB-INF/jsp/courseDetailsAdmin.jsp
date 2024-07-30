<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>View Course Details - Admin</title>
		<link href="css/courseDetailsAdmin.css" rel="stylesheet">
		<script type="text/javascript" src="js/courseDetailsAdmin.js"></script>
	</head>
	<body onload="getCourseIdAndDetails()">
		<% request.setAttribute("pageTitle", "Course Details - Admin"); %>
		<% request.setAttribute("image", "img/profileIcon.png"); %>
		<% request.setAttribute("link", "profile"); %>
		
        <jsp:include page="navPages.jsp" />
        <main>
        	<div class="Acolumn">
        		<div class="row">
        			<!-- view details -->
        			<div class="container">
        				<a href=outerCourseDetailsAdmin>
        					<button id="viewDetails" type="button">View Course Details</button>
        				</a>
        				
        			</div>
        		</div> 
        	
        	</div>
        	<div class="Acolumn">
        		<div class="row">
        			<!-- view who has registered interest in a course -->
        			<div class="regIntPeeps">
        				<h3>Registered Interest Attendees</h3>
        			</div>
        		</div>
        		<div class="row">
        			<!-- view who has booked a course -->
        			<div class="bookedPeeps">
        				<h3>Signed Up Attendees</h3>
        			</div>
        		</div>
        	</div>
        	
	
        
        </main>

		<jsp:include page="footer.jsp"/>
	</body>
</html>
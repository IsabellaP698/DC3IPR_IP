<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Course Details - Admin</title>
		<link href="css/courseDetailsAdmin.css" rel="stylesheet">
	</head>
	<body>
		<% request.setAttribute("pageTitle", "Course Details - Admin"); %>
		<% request.setAttribute("image", "img/profileIcon.png"); %>
		<% request.setAttribute("link", "profile"); %>
		
        <jsp:include page="navPages.jsp" />
        <main>
        	<div class="Acolumn">
        		<div class="row">
        			<!-- edit course -->
        			<div class="container">
        				<button id="editCourse" type="button">Edit Course</button>
        			</div>
        		</div>
        		<div class="row">
        			<!-- view details -->
        			<div class="container">
        				<button id="viewDetails" type="button">View Course Details</button>
        			</div>
        		</div> 
        	
        	</div>
        	<div class="Acolumn">
        		<div class="row">
        			<!-- view who has registered interest in a course -->
        			<div class="regIntPeeps">
        			</div>
        		</div>
        		<div class="row">
        			<!-- view who has booked a course -->
        			<div class="bookedPeeps">
        			</div>
        		</div>
        	</div>
        	
	
        
        </main>

		<jsp:include page="footer.jsp"/>
	</body>
</html>
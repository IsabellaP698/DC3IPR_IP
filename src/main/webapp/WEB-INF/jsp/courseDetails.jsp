<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Course Details</title>
		<link href="css/courseDetails.css" rel="stylesheet">
	</head>
	<body>
		<% request.setAttribute("pageTitle", "Course Details"); %>
		<% request.setAttribute("image", "img/profileIcon.png"); %>
		<% request.setAttribute("link", "profile"); %>
		
        <jsp:include page="navPages.jsp" />
        
        <main>
        	<div class="row">
        		<!-- course basic info -->
        		<div class="columnD">
        			<div class="basicInfo">
        			
        			</div>
        		
        		</div>
        		<!-- course further info -->
        		<div class="columnD">
        			<div class="furtherInfo">
        			
        			</div>
        		</div>
        		<div class="columnD">
        			<div class="container">
        				<div class="row">
        					<!-- employee register interest -->
        					<div class="container">
        						<button id="registerInt" type="button">Register Interest</button>
        					</div>
        				</div>
        				<div class="row">
        					<!-- employee signs up -->
        					<div class="container">
        						<button id="signUp" type="button">Sign Up</button>
        					</div>
        				</div> 
        			</div>
        			
        		</div>
        	</div>
        	
        	<!-- add review/comment -->
        	<div class="row">
        		<div class="comments">
        		
        		</div>
        	</div>
        	
        </main>
        
        <jsp:include page="footer.jsp"/>

	</body>
</html>
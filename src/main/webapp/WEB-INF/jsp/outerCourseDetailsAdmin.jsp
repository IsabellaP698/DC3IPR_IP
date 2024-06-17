<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript" src="js/courseDetails.js"></script>
	</head>
	<body onload="adminOnLoad()">
	
		<% request.setAttribute("pageTitle", "Course Details - Admin"); %>
		<% request.setAttribute("image", "img/profileIcon.png"); %>
		<% request.setAttribute("link", "profile"); %>
		
        <jsp:include page="navPages.jsp" />
        
        <main>
        
        	<div class="row">
        		<div class="column1">
        			<a href=courseDetailsAdmin>
						<button id="courseDetailsAdmin" type="button">View Admin Details</button>
					</a>
        		</div>
        		
        		<div class="column1">
        			<!-- edit course -->
        			<button id="editCourse" type="button" onclick="openEditForm()">Edit Course</button>
        		</div>
        	</div>
        	
        	<div class="row"> 
        		<div class="column1"></div>
        		<div class="column1">
        			<div class="formEditContainer">
        				<form class="form" action="courseEdit" method="POST">
        				<label for="field">Field to Change:</label>
    					<select id="field" name="field">
      						<option value="courseName">Course Name</option>
      						<option value="type">Type</option>
      						<option value="organiserName">Organiser Name</option>
      						<option value="courseDesc">Course Description</option>
      						<option value="intFlag">Internal?</option>
      						<option value="extFlag">External?</option>
      						<option value="virt">Virtual?</option>
      						<option value="intper">In-Person?</option>
      						<option value="startDate">Start Date</option>
      						<option value="signupDate">Sign Up Deadline</option>
      						<option value="pmapprov">PM Approval</option>
      						<option value="daapprov">CDA Approval</option>
      						<option value="pracApprov">Practice Approval</option>
      						<option value="diff">Difficulty</option>
      						<option value="length">Length</option>
      						<option value="cert">Is it a cert?</option>
    					</select>
    					
    					<input type="text" id="edit" name="edit" placeholder="Put edit here...">
    					
    					<input type="submit" value="Submit">
        			</form>
        			</div>
        			
        		</div>
        	</div>
			
			<jsp:include page="courseDetails.jsp"/>
		
		</main>
        
        <jsp:include page="footer.jsp"/>

	</body>
</html>
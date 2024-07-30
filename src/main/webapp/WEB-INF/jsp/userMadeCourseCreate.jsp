<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create Course</title>
		<link href="css/courseCreate.css" rel="stylesheet">
	</head>
	<body>
		<% request.setAttribute("pageTitle", "Create a Historic Course"); %>
		<% request.setAttribute("image", "img/profileIcon.png"); %>
		<% request.setAttribute("link", "profile"); %>
		
        <jsp:include page="navPages.jsp" />
        
        <main>
        	<div class="formContainer">
        		<form action="userMadeCourseCreation" method="POST">
    			<label for="cname">CourseName:</label>
    			<input type="text" onkeypress="return ((event.charCode > 64 && event.charCode < 91) || (event.charCode > 96 && event.charCode < 123) || event.charCode == 8 || event.charCode == 32 || (event.charCode >= 48 && event.charCode <= 57));" id="cname" name="courseName" placeholder="Course Name...">

    			<label for="type">Type:</label>
    			<select id="type" name="type">
      				<option value="aws">AWS</option>
      				<option value="softSkills">Soft Skills</option>
      				<option value="azure">Azure</option>
    			</select>
    			
    			<label for="desc">Course Description:</label>
    			<br>
				<textarea onkeypress="return ((event.charCode > 64 && event.charCode < 91) || (event.charCode > 96 && event.charCode < 123) || event.charCode == 8 || event.charCode == 32 || (event.charCode >= 48 && event.charCode <= 57));" rows "5" cols "60" name="desc"></textarea>   
				<br>
				 			
  				<label for="cert">Does this have a certification? :</label>
    			<select id="cert" name="cert">
      				<option value="yes">Yes</option>
      				<option value="no">No</option>
    			</select>
    			
    			<label for="startDate">Start Date:</label>
    			<input type="date" id="startDate" name="startDate" placeholder="Start Date...">

    			
  
    			<input type="submit" value="Submit">
  			</form>
        	</div>
        	
        
        </main>
        
        <jsp:include page="footer.jsp"/>

	</body>
</html>
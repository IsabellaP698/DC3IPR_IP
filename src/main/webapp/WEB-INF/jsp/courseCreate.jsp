<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create/Edit Course</title>
		<link href="css/courseCreate.css" rel="stylesheet">
	</head>
	<body>
		<% request.setAttribute("pageTitle", "Create/Edit a Course"); %>
		<% request.setAttribute("image", "img/profileIcon.png"); %>
		
        <jsp:include page="navPages.jsp" />
        
        <main>
        	<div class="formContainer">
        		<form>
    			<label for="cname">CourseName:</label>
    			<input type="text" id="cname" name="courseName" placeholder="Course Name...">

    			<label for="type">Type:</label>
    			<select id="type" name="type">
      				<option value="aws">AWS</option>
      				<option value="softSkills">Soft Skills</option>
      				<option value="azure">Azure</option>
    			</select>
    			
    			<label for="organiserName">Organiser Name:</label>
    			<input type="text" id="organiserName" name="organiserName" placeholder="Organiser Name...">
    			
    			<label for="intEnt">Internal or External:</label>
    			<select id="intEnt" name="intEnt">
      				<option value="int">Internal</option>
      				<option value="ent">External</option>
    			</select>
    			
    			<label for="virtPer">Virtual or In-Person:</label>
    			<select id="virtPer" name="virtPer">
      				<option value="virt">Virtual</option>
      				<option value="inper">In-Person</option>
    			</select>
    			
    			<label for="desc">Course Description:</label>
				<textarea rows "5" cols "60" name="desc"></textarea>   
				
				<label for="length">Course length (in days):</label>
    			<input type="number" id="length" name="length" placeholder="Course Length...">
				 			
  				<label for="cert">Does this have a certification? :</label>
    			<select id="cert" name="cert">
      				<option value="yes">Yes</option>
      				<option value="no">No</option>
    			</select>
    			
    			<label for="difficulty">Difficulty:</label>
    			<select id="diff" name="diff">
      				<option value="1">1</option>
      				<option value="2">2</option>
      				<option value="3">3</option>
      				<option value="4">4</option>
      				<option value="5">5</option>
    			</select>
    			
    			<label for="startDate">Start Date:</label>
    			<input type="date" id="startDate" name="startDate" placeholder="Start Date...">
    			
    			<label for="deadline">Sign Up Deadline:</label>
    			<input type="date" id="deadline" name="deadline" placeholder="Deadline...">
    			
    			<div class="approval">
    				<p for="approval">Required Approval:</p>
  					<input type="checkbox" id="PM" name="PM" value="PM">
  					<label for="PM"> People Manager</label><br>
  					<input type="checkbox" id="DA" name="DA" value="DA">
  					<label for="DA"> Delivery Area</label><br>
  					<input type="checkbox" id="prac" name="prac" value="prac">
  					<label for="prac"> Practice</label>
    			</div>
    			
  
    			<input type="submit" value="Submit">
  			</form>
        	</div>
        	
        
        </main>
        
        <jsp:include page="footer.jsp"/>

	</body>
</html>
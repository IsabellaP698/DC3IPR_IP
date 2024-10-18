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
		<% request.setAttribute("pageTitle", "Create/Edit a Course"); %>
		<% request.setAttribute("image", "img/profileIcon.png"); %>
		<% request.setAttribute("link", "profile"); %>
		
        <jsp:include page="navPages.jsp" />
        
        <main>
        	<div class="formContainer">
        		<form action="courseCreation" method="POST">
    			<label for="cname">CourseName:</label>
    			<input type="text" maxlength="50" onkeypress="return ((event.charCode > 64 && event.charCode < 91) || (event.charCode > 96 && event.charCode < 123) || event.charCode == 8 || event.charCode == 32 || (event.charCode >= 48 && event.charCode <= 57));" id="cname" name="courseName" placeholder="Course Name...">

    			<label for="type">Type:</label>
    			<select id="type" name="type">
      				<option value="aws">AWS</option>
      				<option value="softSkills">Soft Skills</option>
      				<option value="azure">Azure</option>
    			</select>
    			
    			<label for="organiserName">Organiser Name:</label>
    			<input type="text" onkeypress="return ((event.charCode > 64 && event.charCode < 91) || (event.charCode > 96 && event.charCode < 123) || event.charCode == 8 || event.charCode == 32 || (event.charCode >= 48 && event.charCode <= 57));" id="organiserName" name="organiserName" placeholder="Organiser Name...">
    			
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
    			<br>
				<textarea maxlength="100" onkeypress="return ((event.charCode > 64 && event.charCode < 91) || (event.charCode > 96 && event.charCode < 123) || event.charCode == 8 || event.charCode == 32 || (event.charCode >= 48 && event.charCode <= 57));" rows "5" cols "60" name="desc"></textarea>   
				<br>
				
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
    			<input type="date" id="startDate" name="startDate" placeholder="Start Date..." min="">
    			
    			<label for="deadline">Sign Up Deadline:</label>
    			<input type="date" id="deadline" name="deadline" placeholder="Deadline..." min="">
    			
    			<div class="approval">
    				<p for="approval">Required Approval:</p>
  					<input type="checkbox" id="PM" name="PM" value="yes">
  					<label for="PM"> People Manager</label><br>
  					<input type="checkbox" id="DA" name="DA" value="yes">
  					<label for="DA"> Delivery Area</label><br>
  					<input type="checkbox" id="prac" name="prac" value="yes">
  					<label for="prac"> Practice</label>
    			</div>
    			
  
    			<input type="submit" value="Submit">
  			</form>
        	</div>
        	
        
        </main>
        
        <jsp:include page="footer.jsp"/>
        
        <script>
       	 	// Set today's date as the minimum date
       	 	const today = new Date().toISOString().split('T')[0];
        	document.getElementById('startDate').setAttribute('min', today);
        	
        	document.getElementById('deadline').setAttribute('min', today);
    	</script>

	</body>
</html>
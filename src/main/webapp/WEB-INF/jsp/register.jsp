<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Register</title>
		<link href="css/register.css" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="regNavPages.jsp" />
		
		<h1 style="text-align: center">Register</h1>
		
		<div class="formContainer">
			<form>
				<input type="text" id="fullname" name="fullname" placeholder="Full name">
				<input type="text" id="email" name="email" placeholder="Email address">
				<input type="text" id="pwd" name="pwd" placeholder="Password">
				
				<br>
				<br>
				
				<select id="role" name="role">
  					<option value="" disabled selected>Your Role...</option>
  					<option value="se">Software Engineer</option>
  					<option value="sm">Scrum Master</option>
				</select>
				
				<select id="type1" name="type1">
  					<option value="" disabled selected>Preferred Course Type...</option>
  					<option value="aws">AWS</option>
  					<option value="azure">Azure</option>
  					<option value="softSkills">Soft Skills</option>
				</select>
				
				<select id="type2" name="type2">
  					<option value="" disabled selected>Preferred Course Type...</option>
  					<option value="aws">AWS</option>
  					<option value="azure">Azure</option>
  					<option value="softSkills">Soft Skills</option>
				</select>
				
				<input type="submit" value="Submit">
				
			</form>
		</div>

		<jsp:include page="footer.jsp"/>
	</body>
</html>
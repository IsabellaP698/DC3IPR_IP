<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home</title>
		<link href="css/home.css" rel="stylesheet">
	</head>
	<body>
		<nav class="navbar">
			<div class="topnav-centered" style="text-align: center">
				<div class="logo">
					<img src = "img/caplogo.png">
				</div>
				 <p>Course Repository</p>
			</div>
			
			<div class="topnav-right">
					<img id=logout src = "img/logout.png">
			</div>
			
		</nav>
	
		<!--  display suggested courses -->
		<header style="text-align: center">
			<h1>Home</h1>
		</header>
		
		<main>
			<div class="row">
				<div class="column">
					
					<a href=profile>
						<img src = "img/profileIcon.png">
						<h3>Profile</h3>
					</a>
					
					
					<!-- button for profile -->
				</div>
		
				<div class="column">
				
				<a href=courses>
					<img src = "img/courseIcon.png">
					<!-- button for courses -->
					<h3>Courses</h3>
				</a>
					
				</div>
			</div>
			
		
			<div class="row">
				<div class="column">
					<!-- suggested courses -->
					<div class="newsBulletin">
						<h3>News Bulletin</h3>
				
					</div>
				</div>
				
				<div class="column">
					<!-- suggested courses -->
					<div class="suggestedCourses">
						<h3>Suggested Courses</h3>
				
					</div>
				</div>
				
			</div>
		</main>
		
		<jsp:include page="footer.jsp"/>
		
	</body>
	
	
</html>
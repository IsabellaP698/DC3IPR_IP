<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript" src="js/courseDetails.js"></script>
		<link href="css/courseDetails.css" rel="stylesheet">
	</head>
	<body onload="adminOnLoad()">
		
        
        <main>
        
        <div id=error>
							<%ArrayList<String> errors =  (ArrayList<String>)request.getAttribute("errors");
								if(!errors.isEmpty()) {%>
									<ul>
								<%
									for(String error: errors){%>
					
									<li><%=error%></li>
								<%}%>
							</ul>
							<%}%>
							</div>
							
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
        			<!-- employee signs up -->
        					<div class="container">
        						<button id="signUp" type="button" onclick="openSignUpForm()">Sign Up</button>
        						
        						<div class="form-popup" id="mySignUpForm">
  									<form class="signup-form-container" action="/signUp" method="POST">
  									
  										<button type="button" class="cancel" onclick="closeSignUpForm()">Close</button>
  										
  										<button type="submit" class="btn">Sign Up</button>
  										
    										<h1>Sign Up</h1>

 						 			</form>
								</div>
        					</div>
        					<!-- employee register interest -->
        					<div class="container">
        						<button id="registerInt" type="button" onclick="openRegisterForm()">Register Interest</button>
        						
        						<div class="form-popup" id="myRegisterForm">
  									<form class="register-form-container" action="/registerInt" method="POST">
  									
  										<button type="button" class="cancel" onclick="closeRegisterForm()">Close</button>
  										
  										<button type="submit" class="btn">Register Interest</button>
  										
    										<h1>Register Interest</h1>

    										
 						 			</form>
								</div>
        					</div>
        					
        			</div>
        			
        		</div>
        	
        	
        </main>

	</body>
</html>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="css/courseSearch.css" rel="stylesheet">
		<script type="text/javascript" src="js/courseFilter.js"></script>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<body onload="requestDetails()">
	
	<div id=confMessage>
							<%String message =  (String)request.getAttribute("confMessage");
								if(!message.isEmpty() || message != null) {%>
									<ul>
				
									<li><%=message%></li>
								<%}%>
							</ul>
			</div>
	
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
			
			<div class="search-container">
      			<input type="text" placeholder="Search.." id="search">
      			<button onclick="searchCourse()" type="submit"><i class="fa fa-search"></i></button>
  			</div>
  			
			<div class="filter">
				<div id="myBtnContainer">
  					<button class="btn" onclick="filterSelection('all')"> All</button>
					
					<div class="dropdown">
					<button class="btn">Role</button>
  					<div class="dropdown-content">
    					<button onclick="filterSelection('se')"> Software Engineer</button>
    					<button onclick="filterSelection('sm')"> Scrum Master</button>
  					</div>
  					</div>
  					
  					<div class="dropdown">
  					<button class="btn">Leader</button>
  					<div class="dropdown-content">
    					<button onclick="filterSelection('int')"> Internal</button>
    					<button onclick="filterSelection('ex')"> External</button>
  					</div>
  					</div>
  					
  					<div class="dropdown">
  					<button class="btn">Cert</button>
  					<div class="dropdown-content">
    					<button onclick="filterSelection('cert')"> Cert</button>
    					<button onclick="filterSelection('nocert')"> No Cert</button>
  					</div>
  					</div>
  					
  					<div class="dropdown">
  					<button class="btn">Location</button>
  					<div class="dropdown-content">
    					<button onclick="filterSelection('virt')"> Virtual</button>
    					<button onclick="filterSelection('inp')"> In-Person</button>
  					</div>
  					</div>
  					
  					<div class="dropdown">
  					<button class="btn">Start Date</button>
  					<div class="dropdown-content">
    					<button onclick="filterSelection('sdMay')"> May</button>
    					<button onclick="filterSelection('sdJune')"> June</button>
  					</div>
  					</div>
  					
  					<div class="dropdown">
  					<button class="btn">Sign Up Deadline</button>
  					<div class="dropdown-content">
    					<button onclick="filterSelection('suMarch')"> March</button>
    					<button onclick="filterSelection('suApril')"> April</button>
  					</div>
  					</div>
				
				
				</div>
				
				
    			
			</div>
			
			<div class="courseDisplay">
				<!-- The filterable elements. Note that some have multiple class names (this can be used if they belong to multiple categories) -->
				<div class="container">
 					<div class="filterDiv se">Engineer Course</div>
  					<div class="filterDiv sm">Scrum Master</div>
  					<div class="filterDiv int">Internal Course</div>
  					<div class="filterDiv ex">External Course</div>
  					<div class="filterDiv nocert">No Cert</div>
  					<div class="filterDiv cert">Cert</div>
  					<div class="filterDiv virt">Virtual Course</div>
  					<div class="filterDiv inp">in person course</div>
  					<div class="filterDiv sdMay">may course</div>
  					<div class="filterDiv sdJune ">june course</div>
  					<div class="filterDiv suMarch">march sign up</div>
  					<div class="filterDiv suApril">april sign up</div>
				</div>
			
			</div>

	</body>
</html>
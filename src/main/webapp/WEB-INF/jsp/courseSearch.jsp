<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="css/courseSearch.css" rel="stylesheet">
		<script type="text/javascript" src="js/courseFilter.js"></script>
	</head>
	<body>
       
			
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
    					<button onclick="filterSelection('sdmay')"> May</button>
    					<button onclick="filterSelection('sdjune')"> June</button>
  					</div>
  					</div>
  					
  					<div class="dropdown">
  					<button class="btn">Sign Up Deadline</button>
  					<div class="dropdown-content">
    					<button onclick="filterSelection('sumarch')"> March</button>
    					<button onclick="filterSelection('suapril')"> April</button>
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
  					<div class="filterDiv sdmay">may course</div>
  					<div class="filterDiv sdjune ">june course</div>
  					<div class="filterDiv sumarch">march sign up</div>
  					<div class="filterDiv suapril">april sign up</div>
				</div>
			
			</div>

	</body>
</html>
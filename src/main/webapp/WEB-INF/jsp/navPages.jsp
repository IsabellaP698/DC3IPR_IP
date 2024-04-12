<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="css/navPages.css" rel="stylesheet">
	</head>
	<body>
		<nav>
        <div class="column">
        	<div class="topnav-left">
        		<img class="spadelogo" src="img/spadeLogo.png">
        		<div class="CourRepo">
                	<p>Course Repository</p>
            	</div>
        	</div>
        </div>

        <div class="column">
            <div class="title">
                <p><%= request.getAttribute("pageTitle") %></p> <!-- Dynamic page title -->
            </div>
        </div>

        <div class="column">
            <div class="topnav-right">
            	<div class="changePageIcon">
                    <img src="<%= request.getAttribute("image") %>">
                </div>
               <img id=logout src = "img/logout.png">
            </div>
        </div>
		</nav>

	</body>
</html>
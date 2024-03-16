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
            <div class="spadelogo">
                <img src="img/spadeLogo.png">
            </div>
            <div class="CourRepo">
                <p>Course Repository</p>
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
                <div class="logout">
                    <a href="log-out">Log Out</a>
                </div>
                <div class="arrow">
                    <img src="img/logoutArrow.png">
                </div>
            </div>
        </div>
		</nav>

	</body>
</html>
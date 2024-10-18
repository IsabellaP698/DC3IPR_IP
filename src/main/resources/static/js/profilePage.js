function loadProfilePage() {
	displayBioInfo();
	displayInterestedCourses();
	displaySignedUpCourses();
	displayHistoricCourses();
	displayUserMadeHistoricCourses();
}

function displayHistoricCourses(){
	Historicrequest = new XMLHttpRequest();
    Historicrequest.open("GET", "getHistoricCourses", true);
    Historicrequest.send();
    
    Historicrequest.onreadystatechange = function(){
        processHistoricResponse();
    }; 
}

function processHistoricResponse() {
	
    if (Historicrequest.readyState == 4 && Historicrequest.status == 200) {
        console.log(Historicrequest.responseXML);
		var courses = Historicrequest.responseXML.getElementsByTagName("courses")[0].getElementsByTagName("course"); // this is a double array
		
		console.log(courses);
		var histCoursesData="<strong>Completed Courses: </strong>";
		
		for (i=0; i < courses.length; i++){
			 histCoursesData += "<br>"
			  				+ "Name: " + courses[i].getAttribute("name") 
							+ "<br>"
							+ "Start Date: " + courses[i].getAttribute("startDate");
					   
		}
		document.getElementsByClassName("completedCourses")[0].innerHTML += histCoursesData;
			
		
    }
}

function displayUserMadeHistoricCourses(){
	UserMadeHistoricrequest = new XMLHttpRequest();
    UserMadeHistoricrequest.open("GET", "getUserMadeHistoricCourses", true);
    UserMadeHistoricrequest.send();
    
    UserMadeHistoricrequest.onreadystatechange = function(){
        processUserMadeHistoricResponse();
    }; 
}

function processUserMadeHistoricResponse() {
	
    if (UserMadeHistoricrequest.readyState == 4 && UserMadeHistoricrequest.status == 200) {
        console.log(UserMadeHistoricrequest.responseXML);
		var courses = UserMadeHistoricrequest.responseXML.getElementsByTagName("courses")[0].getElementsByTagName("course"); // this is a double array
		
		console.log(courses);
		var userMadeHistCoursesData="<strong>Historic Courses Completed Before Registery: </strong>";
		
		for (i=0; i < courses.length; i++){
			 userMadeHistCoursesData += "<br>"
			  				+ "Name: " + courses[i].getAttribute("name") 
							+ " Type: " + courses[i].getAttribute("type") 
							+ " Desc: " + courses[i].getAttribute("type") 
							+ " Completion Date: " + courses[i].getAttribute("startDate") 
							+ " Is Cert?: " + courses[i].getAttribute("isCert");
					   
		}
		document.getElementsByClassName("userMadeCourses")[0].innerHTML += userMadeHistCoursesData;
			
		
    }
}

function displayInterestedCourses(){
	Interestedrequest = new XMLHttpRequest();
    Interestedrequest.open("GET", "getInterestedCourses", true);
    Interestedrequest.send();
    
    Interestedrequest.onreadystatechange = function(){
        processInterestedResponse();
    }; 
}

function processInterestedResponse() {
	
    if (Interestedrequest.readyState == 4 && Interestedrequest.status == 200) {
        console.log(Interestedrequest.responseXML);
		var courses = Interestedrequest.responseXML.getElementsByTagName("courses")[0].getElementsByTagName("course"); // this is a double array
		
		console.log(courses);
		var profIntCoursesData="<strong>Courses Registered Interest In: </strong>";
		
		for (i=0; i < courses.length; i++){
			 profIntCoursesData += "<br>"
			  				+ "Name: " + courses[i].getAttribute("name") 
							+ "<br>"
							+ "Sign up Deadline: " + courses[i].getAttribute("deadline");
					   
		}
		document.getElementsByClassName("currentCourses")[0].innerHTML += profIntCoursesData;
			
		
    }
}

function displaySignedUpCourses(){
	SignedUprequest = new XMLHttpRequest();
    SignedUprequest.open("GET", "getSignedUpCourses", true);
    SignedUprequest.send();
    
    SignedUprequest.onreadystatechange = function(){
        processSignedUpResponse();
    }; 
}

function processSignedUpResponse() {
	
    if (SignedUprequest.readyState == 4 && SignedUprequest.status == 200) {
        console.log(SignedUprequest.responseXML);
		var scourses = SignedUprequest.responseXML.getElementsByTagName("courses")[0].getElementsByTagName("course"); // this is a double array
		
		console.log(scourses);
		var profSignCoursesData= "<br><br><strong>Courses Signed Up To: </strong>";
		
		for (i=0; i < scourses.length; i++){
			 profSignCoursesData += "<br>"
			  				+ "Name: " + scourses[i].getAttribute("name") 
							+ "<br>"
							+ "Start Date: " + scourses[i].getAttribute("startDate");
					   
		}
		document.getElementsByClassName("currentCourses")[0].innerHTML += profSignCoursesData;
			
		
    }
}

function displayBioInfo(){
	bioRequest = new XMLHttpRequest();
    bioRequest.open("GET", "getBioInfo", true);
    bioRequest.send();
    
    bioRequest.onreadystatechange = function(){
        processBioResponse();
    }; 
}

function processBioResponse() {
	
    if (bioRequest.readyState == 4 && bioRequest.status == 200) {
        console.log(bioRequest.responseXML);
		var users = bioRequest.responseXML.getElementsByTagName("employee")[0].getElementsByTagName("bio"); // this is a double array
		
		var bioData="<strong>Bio: </strong>";
		
		for (i=0; i < users.length; i++){
			 bioData += "<br>" + "Name: " + users[i].getAttribute("name") 
							+ "<br>"
							+ "Email: " + users[i].getAttribute("email") 
							+ "<br>"
							+ "Site Admin?: " + users[i].getAttribute("isAdmin") 
							+ "<br>"
							+ "Role: " + users[i].getAttribute("role");
							
			if (users[i].getAttribute("pref1") != null){
				bioData +="<br>";
				bioData += "Preference: " + users[i].getAttribute("pref1");
			}
			if (users[i].getAttribute("pref2") != null){
				bioData +="<br>";
				bioData += "Preference 2: " + users[i].getAttribute("pref2");
			}
			if (users[i].getAttribute("pref3") != null){
				bioData +="<br>";
				bioData += "Preference 3: " + users[i].getAttribute("pref3");
			}
			if (users[i].getAttribute("pref4") != null){
				bioData +="<br>";
				bioData += "Preference 4: " + users[i].getAttribute("pref4");
			}
			if (users[i].getAttribute("pref5") != null){
				bioData +="<br>";
				bioData += "Preference 5: " + users[i].getAttribute("pref5");
			}
					   
		}
		document.getElementsByClassName("bio")[0].innerHTML = bioData;
			
		
    }
}
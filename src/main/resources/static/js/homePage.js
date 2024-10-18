function loadHomePage() {
	displaySuggestedCourses();
	displayNewCourses();
}

function displayNewCourses(){
	NewRequest = new XMLHttpRequest();
    NewRequest.open("GET", "getNewCourses", true);
    NewRequest.send();
    
    NewRequest.onreadystatechange = function(){
        processNewResponse();
    }; 
}

function processNewResponse() {
	
    if (NewRequest.readyState == 4 && NewRequest.status == 200) {
        console.log(NewRequest.responseXML);
        console.log(NewRequest.responseText);
		var scourses = NewRequest.responseXML.getElementsByTagName("courses")[0].getElementsByTagName("course"); // this is a double array
		
		console.log(scourses);
		var newCoursesData= "";
		
		for (i=0; i < scourses.length; i++){
			 newCoursesData += "<br>"
			 				+ "<a href=outerCourseDetails onclick='addIdToSession("+ scourses[i].getAttribute("id") + ")'>" 
			  				+ "Name: " + scourses[i].getAttribute("name")
							+ " Start Date: " + scourses[i].getAttribute("startDate")
							+ "</a>";
					   
		}
		
		console.log("course data" + newCoursesData);
		document.getElementsByClassName("newsBulletin")[0].innerHTML += newCoursesData;
			
		
    }
}

function displaySuggestedCourses(){
	SuggestedRequest = new XMLHttpRequest();
    SuggestedRequest.open("GET", "getSuggestedCourses", true);
    SuggestedRequest.send();
    
    SuggestedRequest.onreadystatechange = function(){
        processSuggestedResponse();
    }; 
}

function processSuggestedResponse() {
	
    if (SuggestedRequest.readyState == 4 && SuggestedRequest.status == 200) {
        console.log(SuggestedRequest.responseXML);
        console.log(NewRequest.responseText);
		var scourses = SuggestedRequest.responseXML.getElementsByTagName("suggCourses")[0].getElementsByTagName("course"); // this is a double array
		
		console.log(scourses);
		var suggestedCoursesData= "";
		
		for (i=0; i < scourses.length; i++){
			 suggestedCoursesData += "<br>"
			 				+ "<a href=outerCourseDetails onclick='addIdToSession("+ scourses[i].getAttribute("id") + ")'>" 
			  				+ "Name: " + scourses[i].getAttribute("name")
							+ "</a>";
					   
		}
		
		console.log(suggestedCoursesData);
		document.getElementsByClassName("suggestedCourses")[0].innerHTML += suggestedCoursesData;
			
		
    }
}

function addIdToSession(id){
	try {
		window.sessionStorage.setItem("id", id);  } catch (e) {
  }
}
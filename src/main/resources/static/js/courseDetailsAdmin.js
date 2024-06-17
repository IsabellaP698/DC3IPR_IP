function getCourseIdAndDetails(){
  try {
    var courId = window.sessionStorage.getItem("id");
    
    request1 = new XMLHttpRequest();
    request1.open("POST", "getCourseSignUps", true);
    request1.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request1.send("courId=" + courId);
        
    request1.onreadystatechange = function(){
        processResponse1();
    }; 
    
    request2 = new XMLHttpRequest();
    request2.open("POST", "getCourseRegInts", true);
    request2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request2.send("courId=" + courId);
        
    request2.onreadystatechange = function(){
        processResponse2();
    }; 
    
  } catch (e) {
  }
}


function processResponse1() {
	if (request1.readyState == 4 && request1.status == 200) {
        console.log(request1.responseXML);
        
		var namesSignUps = request1.responseXML.getElementsByTagName("courseSignUps")[0].getElementsByTagName("attendee");
			
		console.log(namesSignUps);
	
		
		var signUpData="";
		
		for (i=0; i < namesSignUps.length; i++){
			signUpData += namesSignUps[i].getAttribute("name");
		}
		
		document.getElementsByClassName("bookedPeeps")[0].innerHTML = signUpData;
	}
}

function processResponse2() {
	if (request2.readyState == 4 && request2.status == 200) {
        console.log(request2.responseXML);
	
		var namesInts = request2.responseXML.getElementsByTagName("courseInterests")[0].getElementsByTagName("attendee");
		
		console.log(namesInts);
	
		var interestedData="";
	
		
		for (i=0; i < namesInts.length; i++){
			interestedData += namesInts[i].getAttribute("name");
		}
		
		document.getElementsByClassName("regIntPeeps")[0].innerHTML = interestedData;
	}
}



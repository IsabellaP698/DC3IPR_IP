function adminOnLoad(){
	getCourseIdAndDetails();
	closeEditForm();
}

function getCourseIdAndDetails(){
  try {
    var courId = window.sessionStorage.getItem("id");
    
    request = new XMLHttpRequest();
    request.open("POST", "getCourseDetailsForPage", true);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send("courId=" + courId);
        
    request.onreadystatechange = function(){
        processResponse();
    }; 
    
  } catch (e) {
  }
}


function processResponse() {
	
    if (request.readyState == 4 && request.status == 200) {
        console.log(request.responseXML);
		var courses = request.responseXML.getElementsByTagName("courses")[0].getElementsByTagName("course"); // this is a double array
		
		console.log(courses);
		var data="";
		
		for (i=0; i < courses.length; i++){
			var basicData = "Name: " + courses[i].getAttribute("name") 
							+ "<br>"
							+ "Type: " + courses[i].getAttribute("type") 
							+ "<br>"
							+ "Organiser Name: " + courses[i].getAttribute("orgName") 
							+ "<br>"
							+ "Description: " + courses[i].getAttribute("desc");
							
							
					   
			var furtherData = "Internal vs External: " + courses[i].getAttribute("company") 
							+ "<br>"
							+ "Virtual vs In-Person: " + courses[i].getAttribute("location") 
							+ "<br>"
							+ "Start date: " + courses[i].getAttribute("startDate") 
							+ "<br>"
							+ "Signup Deadline: " + courses[i].getAttribute("deadline") 
							+ "<br>"
							+ "Required Approval: " 
							+ "<br>"
							+ "<i>Practice: " + courses[i].getAttribute("pracApprov") 
							+ "<br>"
							+ "People Manager: " + courses[i].getAttribute("pmApprov") 
							+ "<br>"
							+ "Delivery Area: " + courses[i].getAttribute("daApprov") + "</i>"
							+ "<br>"
							+ "Certification: " + courses[i].getAttribute("isCert") 
							+ "<br>"
							+ "Length: " + courses[i].getAttribute("length") + " days"
							+ "<br>"
							+ "Difficulty: "
							+ "<br>"
							;
							
			// difficulty traffic light colours				
			if (courses[i].getAttribute("diff") == "1" || courses[i].getAttribute("diff") == "2") {
  				furtherData +=  "<img class='dot' src='img/greenDot.png'> ";
			} else if (courses[i].getAttribute("diff") == "3" || courses[i].getAttribute("diff") == "4"){
				furtherData += "<img class='dot' src='img/orangeDot.png'> ";
			} else {
				furtherData += "<img class='dot' src='img/redDot.png'> ";
			}
			
			//showing either button
   			
			if (courses[i].getAttribute("startDate") == null) {
    			document.getElementById("signUp").style.display = "none";
			} else {
				document.getElementById("registerInt").style.display = "none";

			}
			
			//approval emails
			var approvalEmails = "";
			if (courses[i].getAttribute("pracApprov") == "yes"){
				approvalEmails += "<label for='pracEmail'><b>Practice Email</b></label>";
    			approvalEmails += "<input type='text' placeholder=' Enter Practice Email' name='pracEmail' required>";
			}  
			if (courses[i].getAttribute("pmApprov") == "yes"){
				approvalEmails += "<label for='pmEmail'><b>People Manager Email</b></label>";
    			approvalEmails += "<input type='text' placeholder=' Enter People Manager Email' name='pmEmail' required>";
			}  
			if (courses[i].getAttribute("daApprov") == "yes"){
				approvalEmails += "<label for='daEmail'><b>Delivery Area Email</b></label>";
    			approvalEmails += "<input type='text' placeholder=' Enter Delivery Area Email' name='daEmail' required>";
			}

			
			//populate cour id hidden input
			var inputData = "<input type='hidden' name='cour_ID' value='"+ window.sessionStorage.getItem("id") +"' />";
					   
		}
				
		document.getElementsByClassName("basicInfo")[0].innerHTML = basicData;
		
		document.getElementsByClassName("furtherInfo")[0].innerHTML = furtherData;
		
		document.getElementsByClassName("register-form-container")[0].innerHTML += inputData;
		
		document.getElementsByClassName("signup-form-container")[0].innerHTML += approvalEmails;
		
		document.getElementsByClassName("signup-form-container")[0].innerHTML += inputData;
		
		
    }
}

function openRegisterForm() {
  document.getElementById("myRegisterForm").style.display = "block";
}

function closeRegisterForm() {
  document.getElementById("myRegisterForm").style.display = "none";
}

function openSignUpForm() {
  document.getElementById("mySignUpForm").style.display = "block";
}

function closeSignUpForm() {
  document.getElementById("mySignUpForm").style.display = "none";
}

function openEditForm() {
  var elems = document.getElementsByClassName("formEditContainer");
  for (var i=0;i<elems.length;i+=1){
 	 elems[i].style.display = 'block';
	}
  
  var inputData = "<input type='hidden' name='cour_ID' value='"+ window.sessionStorage.getItem("id") +"' />";
  
  document.getElementsByClassName("form")[0].innerHTML += inputData;
  
  
}

function closeEditForm() {
  var elems = document.getElementsByClassName("formEditContainer");
  for (var i=0;i<elems.length;i+=1){
 	 elems[i].style.display = 'none';
	}
}


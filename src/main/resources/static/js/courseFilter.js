filterSelection("all")
function filterSelection(c) {
  var x, i;
  x = document.getElementsByClassName("filterDiv");
  if (c == "all") c = "";
  for (i = 0; i < x.length; i++) {
    w3RemoveClass(x[i], "show");
    if (x[i].className.indexOf(c) > -1) w3AddClass(x[i], "show");
  }
}

function w3AddClass(element, name) {
  var i, arr1, arr2;
  arr1 = element.className.split(" ");
  arr2 = name.split(" ");
  for (i = 0; i < arr2.length; i++) {
    if (arr1.indexOf(arr2[i]) == -1) {element.className += " " + arr2[i];}
  }
}

function w3RemoveClass(element, name) {
  var i, arr1, arr2;
  arr1 = element.className.split(" ");
  arr2 = name.split(" ");
  for (i = 0; i < arr2.length; i++) {
    while (arr1.indexOf(arr2[i]) > -1) {
      arr1.splice(arr1.indexOf(arr2[i]), 1);     
    }
  }
  element.className = arr1.join(" ");
}

// Add active class to the current button (highlight it)
var btnContainer = document.getElementById("myBtnContainer");
var btns = btnContainer.getElementsByClassName("btn");
for (var i = 0; i < btns.length; i++) {
  btns[i].addEventListener("click", function(){
    var current = document.getElementsByClassName("active");
    current[0].className = current[0].className.replace(" active", "");
    this.className += " active";
  });
}


//getting courses


var request;

function requestDetails() {
   request = new XMLHttpRequest();
    request.open("GET", "showCourses", true);
    request.send();
    
    request.onreadystatechange = function(){
        processResponse();
    }; 
}

function processResponse() {
	
    if (request.readyState == 4 && request.status == 200) {
        console.log(request.responseXML);
		var courses = request.responseXML.getElementsByTagName("courses")[0].getElementsByTagName("course"); // this is a double array
		
		console.log(courses);
		var data="";
		
		for (i=0; i < courses.length; i++){
			var data = data + "<div class='filterDiv " 
					   + courses[i].getAttribute("company") + " "
					   + courses[i].getAttribute("role1") + " "
					   + courses[i].getAttribute("isCert") + " "
					   + courses[i].getAttribute("location") + " "
					   + courses[i].getAttribute("startDate") + " "
					   + courses[i].getAttribute("deadline")
					   + "'>" 
					   + courses[i].getAttribute("name")
					   + "</div";
					   
		}
				console.log(data);
		document.getElementsByClassName("container")[0].innerHTML = data;
			
		
    }
}

// to search for courses
function searchCourse() {
  let input = document.getElementById('search').value
  
  request = new XMLHttpRequest();
    request.open("POST", "searchForCourses", true);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send("input=" + input);
        
    request.onreadystatechange = function(){
        processResponse();
    }; 
}







package capgemini.courseRepo.demo.controllers;

import java.io.PrintWriter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import capgemini.courseRepo.demo.models.UserSession;
import capgemini.courseRepo.demo.services.CourseService;
import capgemini.courseRepo.demo.services.EmployeeService;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("userSession")
public class ProfileController {
	
	@Autowired(required=false)
	CourseService courseService;
	
	@Autowired(required=false)
	EmployeeService employeeService;

	@RequestMapping(value= {"/profile"}, method=RequestMethod.GET)
	protected String goToProfile() throws Exception {
		return "profile";
	}
	

	@RequestMapping(value= {"/getInterestedCourses"}, method=RequestMethod.GET)
	protected String getInterestedCourses(HttpServletResponse response, 
									  @ModelAttribute("userSession") UserSession userSession) throws Exception {
		
		response.setContentType("application/xml;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    
	    //get all courses from database
	    ArrayList<String> courses = courseService.getInterestedCourses(String.valueOf(userSession.getEmployeeID()));
	    //for each courses
	    try {
	         if (courses != null) {
	        	//print out xml <courses> </courses>
	        	 out.println("<courses>");
	        	 for (String s : courses) {
	        		 out.println(s);
	        	 }
	        	 out.println("</courses>");
	         } else {
	        	 out.println("courses return isnt working");
	         }
	     } finally {
	         out.close();
	     }
	    
		return "profile";
	}
	
	@RequestMapping(value= {"/getSignedUpCourses"}, method=RequestMethod.GET)
	protected String getSignedUpCourses(HttpServletResponse response, 
									  @ModelAttribute("userSession") UserSession userSession) throws Exception {
		
		response.setContentType("application/xml;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    
	    //get all courses from database
	    ArrayList<String> courses = courseService.getSignedUpCourses(String.valueOf(userSession.getEmployeeID()));
	    //for each courses
	    try {
	         if (courses != null) {
	        	//print out xml <courses> </courses>
	        	 out.println("<courses>");
	        	 for (String s : courses) {
	        		 out.println(s);
	        	 }
	        	 out.println("</courses>");
	         } else {
	        	 out.println("courses return isnt working");
	         }
	     } finally {
	         out.close();
	     }
	    
		return "profile";
	}
	
	@RequestMapping(value= {"/getHistoricCourses"}, method=RequestMethod.GET)
	protected String getHistoricCourses(HttpServletResponse response, 
									  @ModelAttribute("userSession") UserSession userSession) throws Exception {
		
		response.setContentType("application/xml;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    
	    //get all courses from database
	    ArrayList<String> courses = courseService.getHistoricCourses(String.valueOf(userSession.getEmployeeID()));
	    //for each courses
	    try {
	         if (courses != null) {
	        	//print out xml <courses> </courses>
	        	 out.println("<courses>");
	        	 for (String s : courses) {
	        		 out.println(s);
	        	 }
	        	 out.println("</courses>");
	         } else {
	        	 out.println("courses return isnt working");
	         }
	     } finally {
	         out.close();
	     }
	    
		return "profile";
	}
	
	@RequestMapping(value= {"/getUserMadeHistoricCourses"}, method=RequestMethod.GET)
	protected String getUserMadeHistoricCourses(HttpServletResponse response, 
									  @ModelAttribute("userSession") UserSession userSession) throws Exception {
		
		response.setContentType("application/xml;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    
	    //get all courses from database
	    ArrayList<String> courses = courseService.getUserMadeHistoricCourses(String.valueOf(userSession.getEmployeeID()));
	    //for each courses
	    try {
	         if (courses != null) {
	        	//print out xml <courses> </courses>
	        	 out.println("<courses>");
	        	 for (String s : courses) {
	        		 out.println(s);
	        	 }
	        	 out.println("</courses>");
	         } else {
	        	 out.println("courses return isnt working");
	         }
	     } finally {
	         out.close();
	     }
	    
		return "profile";
	}
	
	@RequestMapping(value= {"/getBioInfo"}, method=RequestMethod.GET)
	protected String getBioInfo(HttpServletResponse response, 
									  @ModelAttribute("userSession") UserSession userSession) throws Exception {
		
		response.setContentType("application/xml;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    
	    //get all courses from database
	    String bio = employeeService.getBioInfo(String.valueOf(userSession.getEmployeeID()));
	    //for each courses
	    try {
	         if (bio != null) {
	        	//print out xml <courses> </courses>
	        	 out.println("<employee>");
	        		 out.println(bio);
	        	 out.println("</employee>");
	         } else {
	        	 out.println("employee bio return isnt working");
	         }
	     } finally {
	         out.close();
	     }
	    
		return "profile";
	}
	
	@ModelAttribute(name = "userSession")
	public UserSession setUserInSession(UserSession userSession) {
		return new UserSession();
	}
	
}

package capgemini.courseRepo.demo.controllers;

import java.io.PrintWriter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import capgemini.courseRepo.demo.models.UserSession;
import capgemini.courseRepo.demo.services.CourseService;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("userSession")
public class HomepageController {
	
	@Autowired(required=false)
	CourseService courseService;

	
	@RequestMapping(value= {"/home"}, method=RequestMethod.GET)
	protected String defaultRoute() throws Exception {
		return "homepage";
	}
	
	@RequestMapping(value= {"/getSuggestedCourses"}, method=RequestMethod.GET)
	protected String getSuggestedCourses(HttpServletResponse response, 
									  @ModelAttribute("userSession") UserSession userSession) throws Exception {
		
		response.setContentType("application/xml;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    
	    //get all courses from database
	    ArrayList<String> courses = courseService.getSuggestedCourses(String.valueOf(userSession.getEmployeeID()));
	    //for each courses
	    try {
	         if (courses != null) {
	        	//print out xml <courses> </courses>
	        	 out.println("<suggCourses>");
	        	 for (String s : courses) {
	        		 out.println(s);
	        	 }
	        	 out.println("</suggCourses>");
	         } else {
	        	 out.println("courses return isnt working");
	         }
	     } finally {
	         out.close();
	     }
	    
		return "homepage";
	}
	
	@RequestMapping(value= {"/getNewCourses"}, method=RequestMethod.GET)
	protected String getNewsBulletinCourses(HttpServletResponse response, 
									  @ModelAttribute("userSession") UserSession userSession) throws Exception {
		
		response.setContentType("application/xml;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    
	    //get all courses from database
	    ArrayList<String> courses = courseService.getNewsBulletinCourses();
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
	    
		return "homepage";
	}
	
	@ModelAttribute(name = "userSession")
	public UserSession setUserInSession(UserSession userSession) {
		return new UserSession();
	}

}

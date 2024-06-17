package capgemini.courseRepo.demo.controllers;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import capgemini.courseRepo.demo.models.UserSession;
import capgemini.courseRepo.demo.services.CourseService;
import jakarta.servlet.http.HttpServletResponse;

import capgemini.courseRepo.demo.entities.CourseEntity;

@Controller
@SessionAttributes("userSession")
public class GetCoursesFromDBController {
	
	@Autowired(required=false)
	CourseService courseService;


	@RequestMapping(value= {"/showCourses"}, method=RequestMethod.GET)
	protected String getCoursesFromDB(HttpServletResponse response, 
									  @ModelAttribute("userSession") UserSession userSession) throws Exception {
		
		response.setContentType("application/xml;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    
	    //get all courses from database
	    ArrayList<String> courses = returnAllCourses();
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
	    
	     
		if (userSession.isAdmin()) {
			return "coursesAdmin";
		} else {
			
		}
		return "courses";
	}
	
	@RequestMapping(value= {"/searchForCourses"}, method=RequestMethod.POST)
	protected String getSearchedCoursesFromDB(HttpServletResponse response, 
									  @ModelAttribute("userSession") UserSession userSession,
									  @RequestParam(value = "input", required = false) String searchInput,
									  Model model) throws Exception {
		
		response.setContentType("application/xml;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    
	    //get all courses from database
	    ArrayList<String> courses = returnSearchedCourses(searchInput);
	    //for each courses
	    try {
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
	    } catch (Exception e) {
	    	List<String> errors = new ArrayList<>();
	    	errors.add("There are no courses matching your search input");
	    	model.addAttribute("errors", errors);
	    	if (userSession.isAdmin()) {
				return "coursesAdmin";
			} else {
				
			}
			return "courses";
	    }
	    
	     
		if (userSession.isAdmin()) {
			return "coursesAdmin";
		} else {
			
		}
		return "courses";
	}
	
	
	
	
	@RequestMapping(value= {"/getCourseDetailsForPage"}, method=RequestMethod.POST)
	protected String getCourseDetailsForPage(HttpServletResponse response, 
									  @ModelAttribute("userSession") UserSession userSession,
									  @RequestParam(value = "courId", required = false) String courId,
									  Model model) throws Exception {
		
		response.setContentType("application/xml;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    
	    //get all courses from database
	    String course = getCourseDetails(courId);
	    //for each courses
	    try {
	    	try {
	    		if (course != null) {
	    			//print out xml <courses> </courses>
	    			out.println("<courses>");
	    			
	    			out.println(course);
	    			
	    			out.println("</courses>");
	    		} else {
	    			out.println("courses return isnt working");
	    		}
	    	} finally {
	    		out.close();
	    	}
	    } catch (Exception e) {
//	    	List<String> errors = new ArrayList<>();
//	    	errors.add("There are no courses matching your search input");
//	    	model.addAttribute("errors", errors);
//	    	if (userSession.isAdmin()) {
//				return "coursesAdmin";
//			} else {
//				
//			}
//			return "courses";
	    }
	    
	     
		if (userSession.isAdmin()) {
			return "courseDetailsAdmin";
		} else {
			
		}
		return "courseDetails";
	}
	
	
	public ArrayList<String> returnAllCourses() throws SQLException{
		return courseService.returnAllCourses();
	}
	
	public ArrayList<String> returnSearchedCourses(String searchInput) throws SQLException{
		return courseService.returnSearchedCourses(searchInput);
	}
	
	public String getCourseDetails(String courId) throws SQLException{
		return courseService.getCourseDetails(courId);
	}
	
	
	@ModelAttribute(name = "userSession")
	public UserSession setUserInSession(UserSession userSession) {
		return new UserSession();
	}
}

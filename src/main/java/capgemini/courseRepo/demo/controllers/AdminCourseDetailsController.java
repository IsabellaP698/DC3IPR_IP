package capgemini.courseRepo.demo.controllers;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import capgemini.courseRepo.demo.models.UserSession;
import capgemini.courseRepo.demo.services.AttendeeService;
import capgemini.courseRepo.demo.services.CourseService;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AdminCourseDetailsController {
	
	@Autowired(required=false)
	AttendeeService attendeeService;
	
	@Autowired(required=false)
	CourseService courseService;
	
	@RequestMapping(value= {"/outerCourseDetailsAdmin"}, method=RequestMethod.GET)
	protected String getOuterCourseDetailsAdmin(@ModelAttribute("errors") ArrayList<String> vlist, @ModelAttribute("userSession") UserSession userSession) throws Exception {
		return "outerCourseDetailsAdmin";
	}
	
	@RequestMapping(value= {"/courseDetailsAdmin"}, method=RequestMethod.GET)
	protected String getCourseDetailsAdmin(@ModelAttribute("errors") ArrayList<String> vlist, @ModelAttribute("userSession") UserSession userSession) throws Exception {
		return "courseDetailsAdmin";
	}
	
	@RequestMapping(value= {"/getCourseSignUps"}, method=RequestMethod.POST)
	protected String getCourseSignUps(HttpServletResponse response, 
									  @ModelAttribute("userSession") UserSession userSession,
									  @RequestParam(value = "courId", required = false) String courId,
									  Model model) throws Exception {
		
		response.setContentType("application/xml;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    
	    //get all courses sign ups from database
	    ArrayList<String> courseSignUps = getCourseSignUps(courId);
	    
	    //for each courses
	    try {
	    	try {
	    		if (courseSignUps != null) {
	    			//print out xml <courses> </courses>
	    			out.println("<courseSignUps>");
	    			for (String su : courseSignUps) {
	    				out.println(su);
	    			}
	    			out.println("</courseSignUps>");
	    		} else {
	    			out.println("courseSignUps isnt working");
	    		}
	    		
	    	} finally {
	    		out.close();
	    	}
	    } catch (Exception e) {
	    	out.println("idk whats going on");
	    }
	    
	     
		if (userSession.isAdmin()) {
			return "courseDetailsAdmin";
		} else {
			
		}
		return "courseDetails";
	}
	
	@RequestMapping(value= {"/getCourseRegInts"}, method=RequestMethod.POST)
	protected String getCourseRegInts(HttpServletResponse response, 
									  @ModelAttribute("userSession") UserSession userSession,
									  @RequestParam(value = "courId", required = false) String courId,
									  Model model) throws Exception {
		
		response.setContentType("application/xml;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    
	   //get all courses interests from database
	    ArrayList<String> courseInterests = getCourseInterests(courId);
	    
	    //for each courses
	    try {
	    	try {
	    		if (courseInterests != null) {
	    			//print out xml <courses> </courses>
	    			out.println("<courseInterests>");
	    			for (String su : courseInterests) {
	    				out.println(su);
	    			}
	    			out.println("</courseInterests>");
	    		} else {
	    			out.println("courseInterests isnt working");
	    		}
	    		
	    	} finally {
	    		out.close();
	    	}
	    } catch (Exception e) {
	    	out.println("idk whats going on");
	    }
	    
	     
		if (userSession.isAdmin()) {
			return "courseDetailsAdmin";
		} else {
			
		}
		return "courseDetails";
	}
	
	@RequestMapping(value= {"/courseEdit"}, method=RequestMethod.POST)
	protected String editCourse(@ModelAttribute("errors") ArrayList<String> vlist, @RequestParam Map<String, String> formData, @ModelAttribute("userSession") UserSession userSession) throws Exception {
		editCourse(formData);
		
		if (userSession.isAdmin()) {
			return "outerCourseDetailsAdmin";
		} else {
			
		}
		return "outerCourseDetails";
	}
	
	private void editCourse(Map<String, String> formData) throws Exception {
		
		String editField = formData.get("field");
		String editChange = formData.get("edit");
		String courID = formData.get("cour_ID");
		
		courseService.editCourse(editField, editChange, courID);
		
	}
	
	
	
	public ArrayList<String> getCourseSignUps(String courId) throws SQLException{
		return attendeeService.getCourseSignUps(courId);
	}
	
	public ArrayList<String> getCourseInterests(String courId) throws SQLException{
		return attendeeService.getCourseInterests(courId);
	}

}

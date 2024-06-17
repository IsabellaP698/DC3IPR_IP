package capgemini.courseRepo.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import capgemini.courseRepo.demo.models.UserSession;
import capgemini.courseRepo.demo.services.AttendeeService;
import capgemini.courseRepo.demo.services.EmployeeService;


@Controller
@SessionAttributes("userSession")
public class CourseDetailsController {
	
	@Autowired(required=false)
	AttendeeService attendeeService;
	
	@Autowired(required=false)
	EmployeeService employeeService;
	
	@RequestMapping(value= {"/outerCourseDetails"}, method=RequestMethod.GET)
	protected String getCourseDetails(@ModelAttribute("errors") ArrayList<String> vlist, @ModelAttribute("userSession") UserSession userSession) throws Exception {
		
		if (userSession.isAdmin()) {
			return "outerCourseDetailsAdmin";
		} 
		return "outerCourseDetails";
	}
	
	@ModelAttribute(name = "userSession")
	public UserSession setUserInSession(UserSession userSession) {
		return new UserSession();
	}
	
	@RequestMapping(value= {"/registerInt"}, method=RequestMethod.POST)
	protected String registerInterestInCourse(@ModelAttribute("confMessage") String message, 
											  @ModelAttribute("errors") ArrayList<String> vlist, 
											  @RequestParam Map<String, String> formData, 
											  @ModelAttribute("userSession") UserSession userSession, Model model) throws Exception {
		
		String email = formData.get("email");
		String courID = formData.get("cour_ID");
		
		String empId = String.valueOf(employeeService.getEmployeeIdFromEmail(email));
		if(empId == null) {
			List<String> errors = new ArrayList<>();
			errors.add("No employee with this email");
			model.addAttribute("errors", errors);
			
			if (userSession.isAdmin()) {
				return "outerCourseDetailsAdmin";
			} 
			return "outerCourseDetails";
		} 
		
		int integer = attendeeService.attendeeRegistersInterest(empId, courID);
		if(integer == 0) {
			List<String> errors = new ArrayList<>();
			errors.add("Could not register interest.");
			model.addAttribute("errors", errors);
			
			if (userSession.isAdmin()) {
				return "outerCourseDetailsAdmin";
			} 
			return "outerCourseDetails";
		} 
		
		String confMessage = "You have successfully registered interest for a course!";
		model.addAttribute("confMessage", confMessage);
		
		if (userSession.isAdmin()) {
			return "coursesAdmin";
		}
		return "courses";
	}
	
	@RequestMapping(value= {"/signUp"}, method=RequestMethod.POST)
	protected String signsUpToCourse(@ModelAttribute("confMessage") String message, 
											  @ModelAttribute("errors") ArrayList<String> vlist, 
											  @RequestParam Map<String, String> formData, 
											  @ModelAttribute("userSession") UserSession userSession, Model model) throws Exception {
		
		String email = formData.get("email");
		String courID = formData.get("cour_ID");
		
		String empId = String.valueOf(employeeService.getEmployeeIdFromEmail(email));
		if(empId == null) {
			List<String> errors = new ArrayList<>();
			errors.add("No employee with this email");
			model.addAttribute("errors", errors);
			
			if (userSession.isAdmin()) {
				return "outerCourseDetailsAdmin";
			} 
			return "outerCourseDetails";
		} 
		
		int integer = attendeeService.attendeeSignsUp(empId, courID);
		if(integer == 0) {
			List<String> errors = new ArrayList<>();
			errors.add("Could not sign up to course.");
			model.addAttribute("errors", errors);
			
			if (userSession.isAdmin()) {
				return "outerCourseDetailsAdmin";
			} 
			return "outerCourseDetails";
		} 
		
		String confMessage = "You have successfully signed up to a course!";
		model.addAttribute("confMessage", confMessage);
		
		if (userSession.isAdmin()) {
			return "coursesAdmin";
		}
		return "courses";
	}
	

}

package capgemini.courseRepo.demo.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import capgemini.courseRepo.demo.models.UserSession;
import capgemini.courseRepo.demo.services.CourseService;

@Controller
@SessionAttributes("userSession")
public class CourseCreateController {
	
	Logger logger = LoggerFactory.getLogger(CourseCreateController.class);
	
	@Autowired(required=false)
	CourseService courseService;

	@RequestMapping(value= {"/courseCreate"}, method=RequestMethod.GET)
	protected String getCourseCreate() throws Exception {
		return "courseCreate";
	}
	
	@RequestMapping(value= {"/userMadeCourseCreate"}, method=RequestMethod.GET)
	protected String getUserMadeCourseCreate() throws Exception {
		return "userMadeCourseCreate";
	}
	
	@RequestMapping(value= {"/courseCreation"}, method=RequestMethod.POST)
	protected String submitCourseCreate(@ModelAttribute("confMessage") String message, 
										@ModelAttribute("errors") ArrayList<String> vlist, 
										@RequestParam Map<String, String> formData,
									    @ModelAttribute("userSession") UserSession userSession) throws Exception {
		createCourse(formData);
		
		if (userSession.isAdmin()) {
			return "coursesAdmin";
		} else {
			
		}
		return "courses";
	}
	
	private void createCourse(Map<String, String> formData) throws Exception {
		String courseName = formData.get("courseName");
		String type = formData.get("type");
		String organiserName = formData.get("organiserName");
		String intEnt = formData.get("intEnt");
		String virtPer = formData.get("virtPer");
		String desc = formData.get("desc");
		String length = formData.get("length");
		String isCert = formData.get("cert");
		String diff = formData.get("diff");
		String startDate = formData.get("startDate");
		String deadline = formData.get("deadline");
		String pmApprov = formData.get("PM");
		String daApprov = formData.get("DA");
		String pracApprov = formData.get("prac");
		
		 courseService.createCourse(courseName, 
								   type, 
								   organiserName, 
								   intEnt, 
								   virtPer,
								   desc, 
								   length,
								   isCert,
								   diff,
								   startDate,
								   deadline,
								   pmApprov,
								   daApprov,
								   pracApprov
								   );
	}
	
	@RequestMapping(value= {"/userMadeCourseCreation"}, method=RequestMethod.POST)
	protected String submitUserMadeCourseCreate(@ModelAttribute("confMessage") String message, 
										@ModelAttribute("errors") ArrayList<String> vlist, 
										@RequestParam Map<String, String> formData,
									    @ModelAttribute("userSession") UserSession userSession) throws Exception {
		createUserMadeCourse(formData, String.valueOf(userSession.getEmployeeID()));
		
		
		return "profile";
	}
	
	private void createUserMadeCourse(Map<String, String> formData, String empId) throws Exception {
		String courseName = formData.get("courseName");
		String type = formData.get("type");
		String desc = formData.get("desc");
		String isCert = formData.get("cert");
		String startDate = formData.get("startDate");
		
		 courseService.createUserMadeCourse(courseName, 
								   type, 
								   desc, 
								   isCert,
								   startDate,
								   empId
								   );
	}
	
	@ModelAttribute(name = "userSession")
	public UserSession setUserInSession(UserSession userSession) {
		return new UserSession();
	}
}

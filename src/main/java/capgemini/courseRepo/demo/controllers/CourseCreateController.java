package capgemini.courseRepo.demo.controllers;

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
	
	@RequestMapping(value= {"/courseCreation"}, method=RequestMethod.POST)
	protected String submitCourseCreate(@RequestParam Map<String, String> formData, @ModelAttribute("userSession") UserSession userSession) throws Exception {
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
	
	@ModelAttribute(name = "userSession")
	public UserSession setUserInSession(UserSession userSession) {
		return new UserSession();
	}
}

package capgemini.courseRepo.demo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import capgemini.courseRepo.demo.models.UserSession;

@Controller
@SessionAttributes("userSession")
public class CoursesController {
	
	@RequestMapping(value= {"/courses"}, method=RequestMethod.GET)
	protected String getCourses(@ModelAttribute("errors") ArrayList<String> vlist,
								@ModelAttribute("userSession") UserSession userSession) throws Exception {
		
		if (userSession.isAdmin()) {
			return "coursesAdmin";
		} else {
			
		}
		return "courses";
	}
	
	@ModelAttribute(name = "userSession")
	public UserSession setUserInSession(UserSession userSession) {
		return new UserSession();
	}
	

}

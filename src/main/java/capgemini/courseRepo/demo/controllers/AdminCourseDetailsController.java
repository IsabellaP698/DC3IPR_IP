package capgemini.courseRepo.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminCourseDetailsController {
	
	@RequestMapping(value= {"/courseDetailsAdmin"}, method=RequestMethod.GET)
	protected String getCourseDetailsAdmin() throws Exception {
		return "courseDetailsAdmin";
	}

}

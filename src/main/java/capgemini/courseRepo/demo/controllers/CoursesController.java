package capgemini.courseRepo.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CoursesController {
	@RequestMapping(value= {"/courses"}, method=RequestMethod.GET)
	protected String getCourses() throws Exception {
		return "courses";
	}

}

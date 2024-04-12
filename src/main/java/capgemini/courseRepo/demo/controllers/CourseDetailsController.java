package capgemini.courseRepo.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CourseDetailsController {
	
	@RequestMapping(value= {"/courseDetails"}, method=RequestMethod.GET)
	protected String getCourseDetails() throws Exception {
		return "courseDetails";
	}

}

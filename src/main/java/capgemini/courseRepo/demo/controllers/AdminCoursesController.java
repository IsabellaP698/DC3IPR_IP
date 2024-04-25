package capgemini.courseRepo.demo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminCoursesController {
	@RequestMapping(value= {"/coursesAdmin"}, method=RequestMethod.GET)
	protected String getCoursesAdmin(@ModelAttribute("errors") ArrayList<String> vlist) throws Exception {
		return "coursesAdmin";
	}

}

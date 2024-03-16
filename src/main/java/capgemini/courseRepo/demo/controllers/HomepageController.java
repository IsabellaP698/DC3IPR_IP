package capgemini.courseRepo.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomepageController {

	
	@RequestMapping(value= {"/","/home"}, method=RequestMethod.GET)
	protected String defaultRoute() throws Exception {
		return "homepage";
	}

}

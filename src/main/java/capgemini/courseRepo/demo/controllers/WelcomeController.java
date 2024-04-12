package capgemini.courseRepo.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

	@RequestMapping(value= {"/","/welcome"}, method=RequestMethod.GET)
	protected String getWelcomePage() throws Exception {
		return "welcome";
	}
}

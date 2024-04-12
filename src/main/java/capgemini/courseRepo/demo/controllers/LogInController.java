package capgemini.courseRepo.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogInController {

	@RequestMapping(value= {"/login"}, method=RequestMethod.GET)
	protected String getLoginPage() throws Exception {
		return "login";
	}
	
}

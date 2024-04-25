package capgemini.courseRepo.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
public class LogOutController {
	
	@RequestMapping(value = "/log-out", method = RequestMethod.GET)
	public String cookies(HttpSession session) {
		session.invalidate();
		return "welcome";
	}

}

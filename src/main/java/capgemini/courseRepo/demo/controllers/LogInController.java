package capgemini.courseRepo.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import capgemini.courseRepo.demo.models.UserSession;
import capgemini.courseRepo.demo.services.EmployeeService;


@Controller
@SessionAttributes("userSession")
public class LogInController {
	
	Logger logger = LoggerFactory.getLogger(LogInController.class);
	
	@Autowired(required=false)
	EmployeeService employeeService;

	@RequestMapping(value= {"/login"}, method=RequestMethod.GET)
	protected String getLoginPage(@ModelAttribute("errors") ArrayList<String> vlist) throws Exception {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	protected String submitLogInInfo(@RequestParam Map<String, String> formData,
									@ModelAttribute("userSession") UserSession userSession,
									  				Model model
	) throws Exception {
		if (validateFormData(formData)) {
			Integer optEmpId;
			try {
				optEmpId = validateSignIn(formData.get("email"), formData.get("pwd"));
				if (optEmpId != null) {
					String userName = getEmployeeName(optEmpId);
					String isAdmin = getifAdmin(optEmpId);
					if (isAdmin.equals("y")) {
			        	userSession.setAdmin(true);
			        } else {
			        	userSession.setAdmin(false);
			        }
					return "homepage";
				} else {
					List<String> errors = new ArrayList<>();
					errors.add("Your email/password is incorrect");
					model.addAttribute("errors", errors);
					return "login";
				}
			} catch (Exception e) {
				logger.error("Exception occurred: ", e);
				return "errors";
			}
		} else {
			List<String> invalidParameters = getInvalidParameters(formData);
			model.addAttribute("errors", invalidParameters);
			return "errors";
		}
	}
	
	private boolean validateFormData(Map<String, String> formData) {
		String email = formData.get("email");
		String password = formData.get("pwd");
		if (email.length() == 0 || password.length() == 0) {
			return false;
		}
		return true;
	}
	
	private Integer validateSignIn(String email, String password)
			throws Exception {
		Integer employeesFound = employeeService.getEmployeeId(email, password);
		if(employeesFound != null) {
			return employeesFound;
		} else {
			return null;
		}
	}
	
	private String getEmployeeName(Integer empId) throws Exception {
		String userName = employeeService.getEmployeeName(empId);
		return userName;
	}
	
	private String getifAdmin(Integer empId) throws Exception {
		String isAdmin = employeeService.getifAdmin(empId);
		return isAdmin;
	}
	
	private List<String> getInvalidParameters(Map<String, String> formData) {
		List<String> errors = new ArrayList<>();
		String email = formData.get("email");
		String password = formData.get("pwd");
		if (email.length() == 0) {
			errors.add("You must provide your email address");
		}
		if (password.length() == 0) {
			errors.add("You must provide your password");
		}
		return errors;
	}
	
	@ModelAttribute(name = "userSession")
	public UserSession setUserInSession(UserSession userSession) {
		return new UserSession();
	}
	
}

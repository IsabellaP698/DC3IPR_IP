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
public class RegisterController {
	
	Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired(required=false)
	EmployeeService employeeService;

	@RequestMapping(value= {"/register"}, method=RequestMethod.GET)
	protected String getRegisterPage(@ModelAttribute("errors") ArrayList<String> vlist) throws Exception {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String submitNewEmployeeRequest(@RequestParam Map<String, String> formData, @ModelAttribute("userSession") UserSession userSession, Model model) {
		try {
            if (validateFormData(formData)) {
            	createEmployeeRecord(formData, userSession);
                return "homepage";
            } else {
                List<String> invalidParameters = getInvalidParameters(formData);
				model.addAttribute("errors", invalidParameters);
				return "register";
            }
        } catch (Exception e) {
			logger.error("Exception occurred: ", e);
			return "errors";
        }
    }
	
	private void createEmployeeRecord(Map<String, String> formData, UserSession userSession)
            throws Exception {
        String fullname = formData.get("fullname");
        String email = formData.get("email");
        String password = formData.get("pwd");
        String isAdmin = formData.get("isAdmin");
        String role = formData.get("role");
        String pref1 = formData.get("type1");
         employeeService.addNewEmployee(fullname, email, password, isAdmin, role, pref1 );
         
         //store emp id in session
         int id = employeeService.getEmployeeId(email, password);
         userSession.setEmployeeID(id);
        
        if (isAdmin.equals("y")) {
        	userSession.setAdmin(true);
        } else {
        	userSession.setAdmin(false);
        }

    }
	
	private boolean validateFormData(Map<String, String> formData) throws Exception {
        String fullname = formData.get("fullname");
        String email = formData.get("email");
        String password = formData.get("pwd");
        String isAdmin = formData.get("isAdmin");
        String role = formData.get("role");
        String pref1 = formData.get("type1");
        if (fullname.length() == 0 || email.length() == 0 || password.length() == 0 || isAdmin.length() == 0 || role.length() == 0 || pref1.length() == 0) {
            return false;
        }
        if(employeeService.doesEmployeeAlreadyExist(email)) {
        	return false;
        }
        return true;
    }
	
	private List<String> getInvalidParameters(Map<String, String> formData) throws Exception {
        List<String> errors = new ArrayList<>();
        String fullname = formData.get("fullname");
        String email = formData.get("email");
        String password = formData.get("pwd");
        String isAdmin = formData.get("isAdmin");
        String role = formData.get("role");
        String pref1 = formData.get("type1");
        if (fullname.length() == 0) {
            errors.add("You must provide your full name");
        }
        if (email.length() == 0) {
            errors.add("You must provide your email address");
        }
        if (password.length() == 0) {
            errors.add("You must provide your password");
        }
        if (isAdmin.length() == 0) {
            errors.add("You must say if you are an admin");
        }
        if (role == null) {
            errors.add("You must provide your role");
        }
        if (pref1.length() == 0) {
            errors.add("You must provide your first preference");
        }
        if(employeeService.doesEmployeeAlreadyExist(email)) {
            errors.add("This email address is already registered to an employee account");
        }
        return errors;
    }
	
	@ModelAttribute(name = "userSession")
	public UserSession setUserInSession(UserSession userSession) {
		return new UserSession();
	}
}

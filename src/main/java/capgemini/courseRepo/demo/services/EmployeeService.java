package capgemini.courseRepo.demo.services;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capgemini.courseRepo.demo.daos.EmployeeDAO;
import capgemini.courseRepo.demo.entities.EmployeeEntity;

//Service classes are decorated with the @Service annotation in Spring.
@Service
public class EmployeeService {

	//inject repository
	@Autowired
	EmployeeDAO employeeDAO;
	
	public int addNewEmployee(String name, String email, String password, String isAdmin, String role, String pref1) throws Exception{
		return employeeDAO.createNewEmployee(name, email, password, isAdmin, role, pref1 );
	}
	
	public String getEmployeeName(Integer empId) throws Exception {
		return employeeDAO.getEmployeeName(empId);
	}
	
	public String getifAdmin(Integer empId) throws Exception {
		return employeeDAO.getifAdmin(empId);
	}
	
	public boolean doesEmployeeAlreadyExist(String email) throws Exception {
		return employeeDAO.doesEmployeeAlreadyExist(email);
	}
	
	public Integer getEmployeeId(String email, String password) {
		try {
			return employeeDAO.getEmployeeId(email, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer getEmployeeIdFromEmail(String email) {
		try {
			return employeeDAO.getEmployeeIdFromEmail(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getEmployeeEmailFromId(String id) {
		try {
			return employeeDAO.getEmployeeEmailFromId(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getBioInfo(String empId) throws SQLException {
		EmployeeEntity emp = employeeDAO.getBioInfo(empId);
		String sXML = new String();
		
		sXML += "<bio name='" + emp.getName(); 
		sXML += "' email='" + emp.getEmail();
		sXML += "' isAdmin='" + emp.isAdmin();
		
		if (emp.getRole().contains("Scrum Master")) {
			sXML += "' role='Scrum Master";
		} else if (emp.getRole().contains("Software Engineer")) {
			sXML += "' role='Software Engineer";
		} else {
			sXML += "' role='N/A";
		}
		
		if (emp.getPref1() != null) {
			if (emp.getPref1().contains("aws")) {
				sXML += "' pref1='AWS";
			}
			if (emp.getPref1().contains("azure")) {
				sXML += "' pref1='Azure";
			}
			if (emp.getPref1().contains("softSkills")) {
				sXML += "' pref1='Soft Skills";
			}
		}
		
		if (emp.getPref2() != null) {
			sXML += "' pref2='" + emp.getPref2();
		}
		
		if (emp.getPref3() != null) {
			sXML += "' pref3='" + emp.getPref3();
		}
		
		if (emp.getPref4() != null) {
			sXML += "' pref4='" + emp.getPref4();
		}
		
		if (emp.getPref5() != null) {
			sXML += "' pref5='" + emp.getPref5();
		}
		
		sXML += "' />";
			
		
		return sXML;
	}
	
}

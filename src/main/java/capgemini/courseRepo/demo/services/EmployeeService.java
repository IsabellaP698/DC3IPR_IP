package capgemini.courseRepo.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capgemini.courseRepo.demo.daos.EmployeeDAO;

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

}

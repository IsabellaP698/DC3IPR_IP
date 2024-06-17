package capgemini.courseRepo.demo.services;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capgemini.courseRepo.demo.daos.AttendeeDAO;

@Service
public class AttendeeService {
	
	@Autowired
	AttendeeDAO attendeeDAO;
	
	public int attendeeRegistersInterest(String empId, String courID) throws Exception {
		
			return attendeeDAO.attendeeRegistersInterest(empId, courID);
	} 
	
	public int attendeeSignsUp(String empId, String courID) throws Exception {
		
		return attendeeDAO.attendeeSignsUp(empId, courID);
	} 
	
	
	public ArrayList<String> getCourseSignUps(String courId) throws SQLException{
		return returnNamesToController(attendeeDAO.getCourseSignUps(courId));
	}
	
	public ArrayList<String> getCourseInterests(String courId) throws SQLException{
		return returnNamesToController(attendeeDAO.getCourseInterests(courId));
	}
	
	public ArrayList<String> returnNamesToController(ArrayList<String> listOfNames){
		ArrayList<String> attendeeXML= new ArrayList<String>();
		
		for (String s : listOfNames) {
			String nameXML = "";
			nameXML= "<attendee name= '" + s + "' />";
			
			attendeeXML.add(nameXML);
		}
		
		return attendeeXML;
	}

}

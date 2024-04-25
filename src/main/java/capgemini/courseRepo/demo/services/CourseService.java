package capgemini.courseRepo.demo.services;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capgemini.courseRepo.demo.daos.CourseDAO;
import capgemini.courseRepo.demo.entities.CourseEntity;

@Service
public class CourseService {
	
	@Autowired
	CourseDAO coursedao;

	public int createCourse(String courseName,
						    String type, 
						    String organiserName, 
						    String intEnt,   
						    String virtPer, 
						    String desc,
						    String length,
						    String isCert,   
						    String diff, 
						    String startDate,
						    String deadline,
						    String pmApprov, 
						    String daApprov,
						    String pracApprov
						    ) throws Exception{
		return coursedao.createCourse(courseName, 
									  type, 
									  organiserName, 
									  intEnt, 
									  virtPer,
									  desc, 
									  length,
									  isCert,
									  diff,
									  startDate,
									  deadline,
									  pmApprov,
									  daApprov,
									  pracApprov );
	}
	
	public ArrayList<String> returnCoursesToController(ArrayList<CourseEntity> list){
		ArrayList<String> cXML= new ArrayList<String>();
		
		for (CourseEntity c : list) {
			String sXML = new String();
			sXML = "<course id='" + c.getId() 
				+ "' name='" + c.getName() 
				+ "' type='" + c.getType();
				
			
			if (c.getInternalFlag().contains("Y")) {
				sXML += "' company='" + "int";
			}
			
			if (c.getExternalFlag().contains("Y")) {
				sXML += "' company='" + "ex";
			}
			
			if ((c.getType().contains("aws") ) || (c.getType().contains("azure"))) {
				sXML += "' role1='" + "se";
			}
			
			if ((c.getType().contains("softSkills"))) {
				sXML += "' role1='" + "se sm";
			}
			
			if ((c.getIsCert().contains("Y"))) {
				sXML += "' isCert='" + "cert";
			} else {
				sXML += "' isCert='" + "nocert";
			}
			
			if (c.getVirtualFlag().contains("Y")) {
				sXML += "' location='" + "virt";
			}
			
			if (c.getInPersonFlag().contains("Y")) {
				sXML += "' location='" + "inp";
			}
			
			if (c.getStartDate() != null) {
				String date = c.getStartDate().toString();
				LocalDate currentDate = LocalDate.parse(date);
				Month month = currentDate.getMonth();
				
				sXML += "' startDate='" + "sd" + month;
			}
			
			if (c.getDeadline() != null) {
				String date = c.getDeadline().toString();
				LocalDate currentDate = LocalDate.parse(date);
				Month month = currentDate.getMonth();
				
				sXML += "' deadline='" + "su" + month;
			}
			
			
			sXML += "' />";
			cXML.add(sXML);
		}
		return cXML;
	}
	
	public ArrayList<String> returnAllCourses() throws SQLException{
		return returnCoursesToController(coursedao.returnAllCourses());
	}
	
	public ArrayList<String> returnSearchedCourses(String input) throws SQLException{
		return returnCoursesToController(coursedao.returnSearchedCourses(input));
	}
		
		
}

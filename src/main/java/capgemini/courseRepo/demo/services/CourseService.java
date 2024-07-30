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
	
	public int createUserMadeCourse(String courseName,
		    				String type, 
		    				String desc,
		    				String isCert,  
		    				String startDate,
		    				String empId
		    ) throws Exception{
			return coursedao.createUserMadeCourse(courseName, 
					  type, 
					  desc, 
					  isCert,
					  startDate,
					  empId );
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
			
			if ((c.getIsCert() != null) && (c.getIsCert().contains("Y"))) {
				sXML += "' isCert='" + "Y";
			} else if ((c.getIsCert() != null) && (c.getIsCert().contains("N"))) {
				sXML += "' isCert='" + "N";
			} else {
				sXML += "' isCert= null'";
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
	
	public ArrayList<String> getInterestedCourses(String id) throws SQLException {
		ArrayList<CourseEntity> intCourses = coursedao.getInterestedCourses(id);
		ArrayList<String> cXML= new ArrayList<String>();
		
		for(CourseEntity c : intCourses) {
			String sXML = new String();
			
			sXML = "<course name='" + c.getName();
			sXML += "' deadline='" + c.getDeadline();
			sXML += "' />";
			cXML.add(sXML);
		}
		
		return cXML;
	}
	
	public ArrayList<String> getSignedUpCourses(String id) throws SQLException {
		ArrayList<CourseEntity> intCourses = coursedao.getSignedUpCourses(id);
		ArrayList<String> cXML= new ArrayList<String>();
		
		for(CourseEntity c : intCourses) {
			String sXML = new String();
			
			sXML = "<course name='" + c.getName();
			sXML += "' startDate='" + c.getStartDate();
			sXML += "' />";
			cXML.add(sXML);
		}
		
		return cXML;
	}
	
	public ArrayList<String> getSuggestedCourses(String id) throws SQLException {
		ArrayList<CourseEntity> suggCourses = coursedao.getSuggestedCourses(id);
		ArrayList<String> cXML= new ArrayList<String>();
		
		for(CourseEntity c : suggCourses) {
			String sXML = new String();
			
			sXML = "<course name='" + c.getName();
			sXML += "' startDate='" + c.getStartDate();
			sXML += "' id='" + c.getId();
			sXML += "' />";
			cXML.add(sXML);
		}
		
		return cXML;
	}
	
	public ArrayList<String> getNewsBulletinCourses() throws SQLException {
		ArrayList<CourseEntity> newsCourses = coursedao.getNewsBulletinCourses();
		ArrayList<String> cXML= new ArrayList<String>();
		
		for(CourseEntity c : newsCourses) {
			String sXML = new String();
			
			sXML = "<course name='" + c.getName();
			sXML += "' startDate='" + c.getStartDate();
			sXML += "' id='" + c.getId();
			sXML += "' />";
			cXML.add(sXML);
		}
		
		return cXML;
	}
	
	public ArrayList<String> getHistoricCourses(String id) throws SQLException {
		ArrayList<CourseEntity> intCourses = coursedao.getHistoricCourses(id);
		ArrayList<String> cXML= new ArrayList<String>();
		
		for(CourseEntity c : intCourses) {
			String sXML = new String();
			
			sXML = "<course name='" + c.getName();
			sXML += "' startDate='" + c.getDeadline();
			sXML += "' />";
			cXML.add(sXML);
		}
		
		return cXML;
	}
	
	public ArrayList<String> getUserMadeHistoricCourses(String id) throws SQLException {
		ArrayList<CourseEntity> userMadeCourses = coursedao.getUserMadeHistoricCourses(id);
		ArrayList<String> cXML= new ArrayList<String>();
		
		for(CourseEntity c : userMadeCourses) {
			String sXML = new String();
			
			sXML = "<course name='" + c.getName();
			sXML += "' type='" + c.getType();
			sXML += "' desc='" + c.getCourseDescription();
			sXML += "' startDate='" + c.getStartDate();
			
			if ((c.getIsCert() != null) && (c.getIsCert().contains("Y"))) {
				sXML += "' isCert='" + "Y";
			} else if ((c.getIsCert() != null) && (c.getIsCert().contains("N"))) {
				sXML += "' isCert='" + "N";
			} else {
				sXML += "' isCert= null'";
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
	
	public String getCourseDetails(String courId) throws SQLException{
		CourseEntity c = coursedao.getCourseDetails(courId);
		String cXML = new String();
		
		cXML = "<course id='" + c.getId() 
		+ "' name='" + c.getName() 
		+ "' type='" + c.getType()
		+ "' orgName='" + c.getOrganiserName()
		+ "' desc='" + c.getCourseDescription()
		+ "' startDate='" + c.getStartDate()
		+ "' deadline='" + c.getDeadline()
		+ "' diff='" + c.getDifficulty()
		+ "' length='" + c.getLength()
		+ "' pmApprov='" + c.getPmApproval()
		+ "' daApprov='" + c.getDaApproval()
		+ "' pracApprov='" + c.getPracApproval()
		;
		
	
	if (c.getInternalFlag().contains("Y")) {
		cXML += "' company='" + "Internal";
	}
	
	if (c.getExternalFlag().contains("Y")) {
		cXML += "' company='" + "External";
	}
	
	if ((c.getIsCert() != null) && (c.getIsCert().contains("Y"))) {
		cXML += "' isCert='" + "Y";
	} else if ((c.getIsCert() != null) && (c.getIsCert().contains("N"))) {
		cXML += "' isCert='" + "N";
	} else {
		cXML += "' isCert= null'";
	}
	
	if (c.getVirtualFlag().contains("Y")) {
		cXML += "' location='" + "Virtual";
	}
	
	if (c.getInPersonFlag().contains("Y")) {
		cXML += "' location='" + "In-Person";
	}

		
	cXML += "' />";
		
		
		return cXML;
	}
	
	public void editCourse(String editField, String editChange, String courID) throws Exception {
		
		coursedao.editCourse(editField, editChange, courID );
	}
		
		
}

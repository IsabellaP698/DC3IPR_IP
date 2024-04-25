package capgemini.courseRepo.demo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import capgemini.courseRepo.demo.entities.CourseEntity;
import jakarta.annotation.PostConstruct;

@Repository
public class CourseDAO extends JdbcDaoSupport{
	
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
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
		Connection conn = dataSource.getConnection();
		PreparedStatement statement = conn.prepareStatement(
				"INSERT INTO COURSE (name, type, organiser_name, course_description, internal_flag, external_flag, "
				+ "virtual_flag, in_person_flag, start_date, deadline, pm_approval, da_approval, prac_approval, difficulty, length_in_days, isCert) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		try {
	        statement.setString(1, courseName);
	        statement.setString(2, type);
	        statement.setString(3, organiserName);
	        statement.setString(4, desc);
	        
	        if (intEnt.equals("int")) {
	        	statement.setString(5, "Y");
	        	statement.setString(6, "N");
	        } else {
	        	statement.setString(5, "N");
	        	statement.setString(6, "Y");
	        }
	        
	        if (virtPer.equals("virt")) {
	        	statement.setString(7, "Y");
	        	statement.setString(8, "N");
	        } else {
	        	statement.setString(7, "N");
	        	statement.setString(8, "Y");
	        }
	        
	        statement.setString(9, startDate);
	        statement.setString(10, deadline);
	        statement.setString(11, pmApprov);
	        statement.setString(12, daApprov);
	        statement.setString(13, pracApprov);
	        statement.setString(14, diff);
	        statement.setString(15, length);
	        
	        if (isCert.equals("yes")) {
	        	statement.setString(16, "Y");
	        } else {
	        	statement.setString(16, "N");
	        }
	        
	        statement.executeUpdate();
	        ResultSet generatedKeys = statement.getGeneratedKeys();
	        generatedKeys.next();
	        return generatedKeys.getInt(1);
		} finally {
	        statement.close();
	        conn.close();
		}
	}
	
	
	public ArrayList<CourseEntity> returnAllCourses() throws SQLException{
		
		Connection conn = null;
	    PreparedStatement sql = null;
	    ResultSet rs = null;
		ArrayList<CourseEntity> courses = new ArrayList<CourseEntity>();
		
		try {
			conn = dataSource.getConnection();
			sql = conn.prepareStatement("SELECT * FROM COURSE");
			rs = sql.executeQuery();
		
			while (rs.next()) {
				CourseEntity c = new CourseEntity();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setType(rs.getString("type"));
				c.setOrganiserName(rs.getString("organiser_name"));
				c.setCourseDescription(rs.getString("course_description"));
				c.setInternalFlag(rs.getString("internal_flag"));
				c.setExternalFlag(rs.getString("external_flag"));
				c.setVirtualFlag(rs.getString("virtual_flag"));
				c.setInPersonFlag(rs.getString("in_person_flag"));
				c.setStartDate(rs.getDate("start_date"));
				c.setDeadline(rs.getDate("deadline"));
				c.setPmApproval(rs.getString("pm_approval"));
				c.setDaApproval(rs.getString("da_approval"));
				c.setPracApproval(rs.getString("prac_approval"));
				c.setDifficulty(rs.getInt("difficulty"));
				c.setLength(rs.getInt("length_in_days"));
				c.setIsCert(rs.getString("isCert"));
				courses.add(c);
			}
		} finally {
			if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
			if (sql != null) try { sql.close(); } catch (SQLException ignore) {}
			if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
		}
		return courses;
	}
	
	public ArrayList<CourseEntity> returnSearchedCourses(String searchInput) throws SQLException{
		
		Connection conn = null;
	    PreparedStatement sql = null;
	    ResultSet rs = null;
		ArrayList<CourseEntity> courses = new ArrayList<CourseEntity>();
		
		try {
			conn = dataSource.getConnection();
			sql = conn.prepareStatement("SELECT * FROM COURSE WHERE UPPER(NAME) LIKE UPPER(?)");
			sql.setString(1, "%" + searchInput + "%");
			rs = sql.executeQuery();
		
			while (rs.next()) {
				CourseEntity c = new CourseEntity();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setType(rs.getString("type"));
				c.setOrganiserName(rs.getString("organiser_name"));
				c.setCourseDescription(rs.getString("course_description"));
				c.setInternalFlag(rs.getString("internal_flag"));
				c.setExternalFlag(rs.getString("external_flag"));
				c.setVirtualFlag(rs.getString("virtual_flag"));
				c.setInPersonFlag(rs.getString("in_person_flag"));
				c.setStartDate(rs.getDate("start_date"));
				c.setDeadline(rs.getDate("deadline"));
				c.setPmApproval(rs.getString("pm_approval"));
				c.setDaApproval(rs.getString("da_approval"));
				c.setPracApproval(rs.getString("prac_approval"));
				c.setDifficulty(rs.getInt("difficulty"));
				c.setLength(rs.getInt("length_in_days"));
				c.setIsCert(rs.getString("isCert"));
				courses.add(c);
			}
		} finally {
			if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
			if (sql != null) try { sql.close(); } catch (SQLException ignore) {}
			if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
		}
		return courses;
	}

}
	

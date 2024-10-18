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
				+ "virtual_flag, in_person_flag, start_date, deadline, pm_approval, da_approval, prac_approval, difficulty, length_in_days, isCert, created_date) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE())", Statement.RETURN_GENERATED_KEYS);
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
	
	public int createUserMadeCourse(String courseName,
							String type, 
							String desc,
							String isCert,  
							String startDate,
							String empId
		    ) throws Exception{
		Connection conn = dataSource.getConnection();
		PreparedStatement statement = conn.prepareStatement(
				"INSERT INTO usermade_hist_course (name, type, course_description, start_date, isCert,madeById ) "
				+ "values (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		try {
	        statement.setString(1, courseName);
	        statement.setString(2, type);
	        statement.setString(3, desc);
	        statement.setString(4, startDate);
	        
	        if (isCert.equals("yes")) {
	        	statement.setString(5, "Y");
	        } else {
	        	statement.setString(5, "N");
	        }
	        
	        statement.setString(6, empId);
	        
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
	
	
public CourseEntity getCourseDetails(String courId) throws SQLException{
		
		Connection conn = null;
	    PreparedStatement sql = null;
	    ResultSet rs = null;
	    CourseEntity c = new CourseEntity();
		
		try {
			conn = dataSource.getConnection();
			sql = conn.prepareStatement("SELECT * FROM COURSE WHERE ID = ?");
			sql.setString(1, courId);
			rs = sql.executeQuery();
		
			while (rs.next()) {
				
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
			}
		} finally {
			if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
			if (sql != null) try { sql.close(); } catch (SQLException ignore) {}
			if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
		}
		return c;
	}

public void editCourse(String editField,String editChange, String courId) throws Exception{
	Connection conn = dataSource.getConnection();
	PreparedStatement statement;
	
	if (editField.equals("courseDesc")) {
		statement = conn.prepareStatement(
				"UPDATE COURSE SET COURSE_DESCRIPTION = ? WHERE ID = ?", Statement.RETURN_GENERATED_KEYS);
	} else if (editField.equals("courseName")) {
		statement = conn.prepareStatement(
				"UPDATE COURSE SET NAME = ? WHERE ID = ?", Statement.RETURN_GENERATED_KEYS);
	} else if (editField.equals("type")) {
		statement = conn.prepareStatement(
				"UPDATE COURSE SET TYPE = ? WHERE ID = ?", Statement.RETURN_GENERATED_KEYS);
	} else if (editField.equals("organiserName")) {
		statement = conn.prepareStatement(
				"UPDATE COURSE SET ORGANISER_NAME = ? WHERE ID = ?", Statement.RETURN_GENERATED_KEYS);
		
	} else if (editField.equals("intFlag")) {
		if (editChange.equals("Y")) {
			statement = conn.prepareStatement(
					"UPDATE COURSE SET INTERNAL_FLAG = ? , EXTERNAL_FLAG = 'N' WHERE ID = ?", Statement.RETURN_GENERATED_KEYS);
		} else {
			statement = conn.prepareStatement(
					"UPDATE COURSE SET INTERNAL_FLAG = ? , EXTERNAL_FLAG = 'Y' WHERE ID = ?", Statement.RETURN_GENERATED_KEYS);
		}
		
	} else if (editField.equals("extFlag")) {
		if (editChange.equals("Y")) {
			statement = conn.prepareStatement(
					"UPDATE COURSE SET INTERNAL_FLAG = 'N' , EXTERNAL_FLAG = ? WHERE ID = ?", Statement.RETURN_GENERATED_KEYS);
		} else {
			statement = conn.prepareStatement(
					"UPDATE COURSE SET INTERNAL_FLAG = 'Y' , EXTERNAL_FLAG = ? WHERE ID = ?", Statement.RETURN_GENERATED_KEYS);
		}
		
		
	} else if (editField.equals("virt")) {
		if (editChange.equals("Y")) {
			statement = conn.prepareStatement(
					"UPDATE COURSE SET VIRTUAL_FLAG = ?, IN_PERSON_FLAG = 'N' WHERE ID = ?", Statement.RETURN_GENERATED_KEYS);
		} else {
			statement = conn.prepareStatement(
					"UPDATE COURSE SET VIRTUAL_FLAG = ?, IN_PERSON_FLAG = 'Y' WHERE ID = ?", Statement.RETURN_GENERATED_KEYS);
		}
		
	} else if (editField.equals("intper")) {
		if (editChange.equals("Y")) {
			statement = conn.prepareStatement(
					"UPDATE COURSE SET VIRTUAL_FLAG = 'N', IN_PERSON_FLAG = ? WHERE ID = ?", Statement.RETURN_GENERATED_KEYS);
		} else {
			statement = conn.prepareStatement(
					"UPDATE COURSE SET VIRTUAL_FLAG = 'Y', IN_PERSON_FLAG = ? WHERE ID = ?", Statement.RETURN_GENERATED_KEYS);
		}
	
	
	
	} else if (editField.equals("startDate")) {
		statement = conn.prepareStatement(
				"UPDATE COURSE SET START_DATE = ? WHERE ID = ?", Statement.RETURN_GENERATED_KEYS);
	} else if (editField.equals("signupDate")) {
		statement = conn.prepareStatement(
				"UPDATE COURSE SET DEADLINE = ? WHERE ID = ?", Statement.RETURN_GENERATED_KEYS);
	} else if (editField.equals("pmapprov")) {
		statement = conn.prepareStatement(
				"UPDATE COURSE SET PM_APPROVAL = ? WHERE ID = ?", Statement.RETURN_GENERATED_KEYS);
	} else if (editField.equals("daapprov")) {
		statement = conn.prepareStatement(
				"UPDATE COURSE SET DA_APPROVAL = ? WHERE ID = ?", Statement.RETURN_GENERATED_KEYS);
	} else if (editField.equals("pracApprov")) {
		statement = conn.prepareStatement(
				"UPDATE COURSE SET PRAC_APPROVAL = ? WHERE ID = ?", Statement.RETURN_GENERATED_KEYS);
	} else if (editField.equals("diff")) {
		statement = conn.prepareStatement(
				"UPDATE COURSE SET DIFFICULTY = ? WHERE ID = ?", Statement.RETURN_GENERATED_KEYS);
	} else if (editField.equals("length")) {
		statement = conn.prepareStatement(
				"UPDATE COURSE SET LENGTH_IN_DAYS = ? WHERE ID = ?", Statement.RETURN_GENERATED_KEYS);
	} else {
		statement = conn.prepareStatement(
				"UPDATE COURSE SET isCert = ? WHERE ID = ?", Statement.RETURN_GENERATED_KEYS);
	}
	
	
	try {
        statement.setString(1, editChange);
        statement.setString(2, courId);
        
        System.out.println(statement);
        statement.executeUpdate();
	} finally {
        statement.close();
        conn.close();
	}
}

	public ArrayList<CourseEntity> getInterestedCourses(String empID) throws SQLException{
		
		Connection conn = null;
	    PreparedStatement sql = null;
	    ResultSet rs = null;
		ArrayList<CourseEntity> courses = new ArrayList<CourseEntity>();
		
		try {
			conn = dataSource.getConnection();
			sql = conn.prepareStatement("SELECT name, deadline FROM COURSE WHERE deadline > SYSDATE() and id in (select course_id from course_Attendee where employee_id = ? and interested_flag = 'Y')");
			sql.setString(1, empID);
			rs = sql.executeQuery();
		
			while (rs.next()) {
				CourseEntity c = new CourseEntity();
				c.setName(rs.getString("name"));
				c.setDeadline(rs.getDate("deadline"));
				courses.add(c);
			}
		} finally {
			if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
			if (sql != null) try { sql.close(); } catch (SQLException ignore) {}
			if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
		}
		return courses;
		
	}
	
public ArrayList<CourseEntity> getSignedUpCourses(String empID) throws SQLException{
		
		Connection conn = null;
	    PreparedStatement sql = null;
	    ResultSet rs = null;
		ArrayList<CourseEntity> courses = new ArrayList<CourseEntity>();
		
		try {
			conn = dataSource.getConnection();
			sql = conn.prepareStatement("SELECT name, start_date FROM COURSE WHERE start_date > SYSDATE() and id in (select course_id from course_Attendee where employee_id = ? and attending_flag = 'Y')");
			sql.setString(1, empID);
			rs = sql.executeQuery();
		
			while (rs.next()) {
				CourseEntity c = new CourseEntity();
				c.setName(rs.getString("name"));
				c.setDeadline(rs.getDate("start_date"));
				courses.add(c);
			}
		} finally {
			if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
			if (sql != null) try { sql.close(); } catch (SQLException ignore) {}
			if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
		}
		return courses;
		
	}

public ArrayList<CourseEntity> getSuggestedCourses(String empID) throws SQLException{
	
	System.out.println(empID);
	
	Connection conn = null;
    PreparedStatement sql = null;
    ResultSet rs = null;
	ArrayList<CourseEntity> courses = new ArrayList<CourseEntity>();
	
	try {
		conn = dataSource.getConnection();
		sql = conn.prepareStatement("select c.id, c.name, c.start_date "
									+ "from employee e"
									+ " join course c"
									+ " on e.pref1 = c.type"
									+ " left outer join course_attendee a"
									+ " on a.employee_id = e.id"
									+ " and a.course_id = c.id"
									+ " where e.id = ?"
									+ " and a.employee_id is null;");
		sql.setString(1, empID);
		System.out.println(sql);
		rs = sql.executeQuery();
	
		while (rs.next()) {
			CourseEntity c = new CourseEntity();
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
			c.setStartDate(rs.getDate("start_date"));
			courses.add(c);
		}
	} finally {
		if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
		if (sql != null) try { sql.close(); } catch (SQLException ignore) {}
		if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
	}
	return courses;
	
}

public ArrayList<CourseEntity> getNewsBulletinCourses() throws SQLException{
	
	Connection conn = null;
    PreparedStatement sql = null;
    ResultSet rs = null;
	ArrayList<CourseEntity> courses = new ArrayList<CourseEntity>();
	
	try {
		conn = dataSource.getConnection();
		sql = conn.prepareStatement("select c.id, c.name, c.start_date "
									+ "from course c"
									+ " where c.created_date >= DATE(NOW() - INTERVAL 7 DAY);");
		System.out.println(sql);
		rs = sql.executeQuery();
	
		while (rs.next()) {
			CourseEntity c = new CourseEntity();
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
			c.setStartDate(rs.getDate("start_date"));
			courses.add(c);
		}
	} finally {
		if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
		if (sql != null) try { sql.close(); } catch (SQLException ignore) {}
		if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
	}
	return courses;
	
}

public ArrayList<CourseEntity> getHistoricCourses(String empID) throws SQLException{
	
	Connection conn = null;
    PreparedStatement sql = null;
    ResultSet rs = null;
	ArrayList<CourseEntity> courses = new ArrayList<CourseEntity>();
	
	try {
		conn = dataSource.getConnection();
		sql = conn.prepareStatement("SELECT name, start_date FROM COURSE WHERE start_date < SYSDATE() and id in (select course_id from course_Attendee where employee_id = ? and attending_flag = 'Y')");
		sql.setString(1, empID);
		rs = sql.executeQuery();
	
		while (rs.next()) {
			CourseEntity c = new CourseEntity();
			c.setName(rs.getString("name"));
			c.setDeadline(rs.getDate("start_date"));
			courses.add(c);
		}
	} finally {
		if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
		if (sql != null) try { sql.close(); } catch (SQLException ignore) {}
		if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
	}
	return courses;
	
}

public ArrayList<CourseEntity> getUserMadeHistoricCourses(String empID) throws SQLException{
	
	Connection conn = null;
    PreparedStatement sql = null;
    ResultSet rs = null;
	ArrayList<CourseEntity> courses = new ArrayList<CourseEntity>();
	
	try {
		conn = dataSource.getConnection();
		sql = conn.prepareStatement("SELECT * FROM usermade_hist_course WHERE madeById = ? ");
		sql.setString(1, empID);
		rs = sql.executeQuery();
	
		while (rs.next()) {
			CourseEntity c = new CourseEntity();
			c.setName(rs.getString("name"));
			c.setType(rs.getString("type"));
			c.setCourseDescription(rs.getString("course_description"));
			c.setStartDate(rs.getDate("start_date"));
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

public String getCourseName(String courID) throws Exception {
	Connection conn = dataSource.getConnection();
	PreparedStatement sql = conn.prepareStatement("select name from course where id = ?");
	sql.setString(1, courID);
	ResultSet rs = sql.executeQuery();
	try {
		if (!rs.next()) {
			throw new Exception("Could not find name for course with ID = " + courID);
		} else {
			return rs.getString("name");
		}
	} finally {
		sql.close();
		conn.close();
	}

}

public String getOrganiserEmail(String courID) throws Exception {
	Connection conn = dataSource.getConnection();
	PreparedStatement sql = conn.prepareStatement("select organiser_email from course where id = ?");
	sql.setString(1, courID);
	ResultSet rs = sql.executeQuery();
	try {
		if (!rs.next()) {
			throw new Exception("Could not find email for course with ID = " + courID);
		} else {
			return rs.getString("organiser_email");
		}
	} finally {
		sql.close();
		conn.close();
	}

}

}
	

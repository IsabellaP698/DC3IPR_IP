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
public class AttendeeDAO extends JdbcDaoSupport{
	
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public int attendeeRegistersInterest(String empId, String courID) throws Exception {
		Connection conn = dataSource.getConnection();
		PreparedStatement statement = conn.prepareStatement(
				"INSERT INTO COURSE_ATTENDEE (COURSE_ID, EMPLOYEE_ID, INTERESTED_FLAG, ATTENDING_FLAG, HISTORIC_FLAG) values (?, ?, 'Y', 'N', 'N')", Statement.RETURN_GENERATED_KEYS);
		try {
	        statement.setString(1, courID);
	        statement.setString(2, empId);
	        statement.executeUpdate();
	        ResultSet generatedKeys = statement.getGeneratedKeys();
	        generatedKeys.next();
	        //return generatedKeys.getInt(1);
	        
	        return 2;
		} finally {
	        statement.close();
	        conn.close();
		}
	}
	
	public int attendeeSignsUp(String empId, String courID) throws Exception {
		Connection conn = dataSource.getConnection();
		PreparedStatement statement = conn.prepareStatement(
				"INSERT INTO COURSE_ATTENDEE (COURSE_ID, EMPLOYEE_ID, INTERESTED_FLAG, ATTENDING_FLAG, HISTORIC_FLAG) values (?, ?, 'N', 'Y', 'N')", Statement.RETURN_GENERATED_KEYS);
		try {
	        statement.setString(1, courID);
	        statement.setString(2, empId);
	        statement.executeUpdate();
	        ResultSet generatedKeys = statement.getGeneratedKeys();
	        generatedKeys.next();
	        //return generatedKeys.getInt(1);
	        
	        return 2;
		} finally {
	        statement.close();
	        conn.close();
		}
	}
	
	public ArrayList<String> getCourseSignUps(String courID) throws SQLException{
		
		Connection conn = null;
	    PreparedStatement sql = null;
	    ResultSet rs = null;
		ArrayList<String> names = new ArrayList<String>();
		
		try {
			conn = dataSource.getConnection();
			sql = conn.prepareStatement("SELECT NAME FROM EMPLOYEE WHERE ID IN (SELECT EMPLOYEE_ID FROM COURSE_ATTENDEE WHERE COURSE_ID = ? AND ATTENDING_FLAG = 'Y')");
			sql.setString(1, courID);
			rs = sql.executeQuery();
		
			while (rs.next()) {
				String s = rs.getString("name");
				names.add(s);
			}
		} finally {
			if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
			if (sql != null) try { sql.close(); } catch (SQLException ignore) {}
			if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
		}
		return names;
	}
	
public ArrayList<String> getCourseInterests(String courID) throws SQLException{
		
		Connection conn = null;
	    PreparedStatement sql = null;
	    ResultSet rs = null;
		ArrayList<String> names = new ArrayList<String>();
		
		try {
			conn = dataSource.getConnection();
			sql = conn.prepareStatement("SELECT NAME FROM EMPLOYEE WHERE ID IN (SELECT EMPLOYEE_ID FROM COURSE_ATTENDEE WHERE COURSE_ID = ? AND INTERESTED_FLAG = 'Y')");
			sql.setString(1, courID);
			rs = sql.executeQuery();
		
			while (rs.next()) {
				String s = rs.getString("name");
				names.add(s);
			}
		} finally {
			if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
			if (sql != null) try { sql.close(); } catch (SQLException ignore) {}
			if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
		}
		return names;
	}

}

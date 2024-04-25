package capgemini.courseRepo.demo.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

@Repository
public class EmployeeDAO extends JdbcDaoSupport {

	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public int createNewEmployee(String name, String email, String password, String isAdmin, String role, String pref1) throws SQLException {
		Connection conn = dataSource.getConnection();
		PreparedStatement statement = conn.prepareStatement(
				"INSERT INTO EMPLOYEE (name, email, password, isAdmin, role, pref1) values (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		try {
	        statement.setString(1, name);
	        statement.setString(2, email);
	        statement.setString(3, password);
	        statement.setString(4, isAdmin);
	        statement.setString(5, role);
	        statement.setString(6, pref1);
	        statement.executeUpdate();
	        ResultSet generatedKeys = statement.getGeneratedKeys();
	        generatedKeys.next();
	        return generatedKeys.getInt(1);
		} finally {
	        statement.close();
	        conn.close();
		}
	}
	
	public String getEmployeeName(Integer empId) throws Exception {
		Connection conn = dataSource.getConnection();
		PreparedStatement sql = conn.prepareStatement("select name from employee where id = ?");
		sql.setInt(1, empId);
		ResultSet rs = sql.executeQuery();
		try {
			if (!rs.next()) {
				throw new Exception("Could not find name for employee with ID = " + empId);
			} else {
				return rs.getString("name");
			}
		} finally {
			sql.close();
			conn.close();
		}

	}
	
	public String getifAdmin(Integer empId) throws Exception {
		Connection conn = dataSource.getConnection();
		PreparedStatement sql = conn.prepareStatement("select isAdmin from employee where id = ?");
		sql.setInt(1, empId);
		ResultSet rs = sql.executeQuery();
		try {
			if (!rs.next()) {
				throw new Exception("Could not find if employee is an admin with ID = " + empId);
			} else {
				return rs.getString("name");
			}
		} finally {
			sql.close();
			conn.close();
		}

	}
	
	public Integer getEmployeeId(String email, String password) throws Exception {
		Connection conn = dataSource.getConnection();
		PreparedStatement sql = conn.prepareStatement("select id from employee where email = ? and password = ?");
		sql.setString(1, email);
		sql.setString(2, password);
		ResultSet rs = sql.executeQuery();
		try {
			if (!rs.next()) {
				throw new Exception("Could not find id for employee with email = " + email);
			} else {
				return rs.getInt("id");
			}
		} finally {
			sql.close();
			conn.close();
		}

	}
	
	public boolean doesEmployeeAlreadyExist(String email) throws Exception {
		Connection conn = dataSource.getConnection();
        PreparedStatement statement = conn.prepareStatement("select count(id) from employee where email = ?");
        statement.setString(1, email);
        ResultSet existingEmailQueryResult = statement.executeQuery();
        existingEmailQueryResult.next();
        boolean alreadyExist = existingEmailQueryResult.getInt(1) > 0;
        statement.close();
        conn.close();
        return alreadyExist;
	}
}

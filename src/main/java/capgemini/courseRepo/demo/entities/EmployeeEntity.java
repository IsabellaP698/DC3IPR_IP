package capgemini.courseRepo.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EmployeeEntity {

	@Id
public Integer id;
	
	public String name;
	
	public String email;
	
	public String password;
	
	public String isAdmin;
	
	public String role;
	
	public String pref1;
	
	public String pref2;

	public String pref3;

	public String pref4;

	public String pref5;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String isAdmin() {
		return isAdmin;
	}

	public void setAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPref1() {
		return pref1;
	}

	public void setPref1(String pref1) {
		this.pref1 = pref1;
	}

	public String getPref2() {
		return pref2;
	}

	public void setPref2(String pref2) {
		this.pref2 = pref2;
	}

	public String getPref3() {
		return pref3;
	}

	public void setPref3(String pref3) {
		this.pref3 = pref3;
	}

	public String getPref4() {
		return pref4;
	}

	public void setPref4(String pref4) {
		this.pref4 = pref4;
	}

	public String getPref5() {
		return pref5;
	}

	public void setPref5(String pref5) {
		this.pref5 = pref5;
	}

}

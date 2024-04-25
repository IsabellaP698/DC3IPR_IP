package capgemini.courseRepo.demo.entities;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;

@Entity
public class CourseEntity {
	
	@Id
	public int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String name;
	
	public String type;
	
	public String courseDescription;
	
	public String organiserName;
	
	public String internalFlag;
	
	public String externalFlag;
	
	public String virtualFlag;
	
	public String inPersonFlag;
	
	public Date startDate;
	
	public Date deadline;
	
	public String pmApproval;
	
	public String daApproval;
	
	public String pracApproval;
	
	public int difficulty;
	
	public int length;
	
	public String isCert;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getOrganiserName() {
		return organiserName;
	}

	public void setOrganiserName(String organiserName) {
		this.organiserName = organiserName;
	}

	public String getInternalFlag() {
		return internalFlag;
	}

	public void setInternalFlag(String internalFlag) {
		this.internalFlag = internalFlag;
	}

	public String getExternalFlag() {
		return externalFlag;
	}

	public void setExternalFlag(String externalFlag) {
		this.externalFlag = externalFlag;
	}

	public String getVirtualFlag() {
		return virtualFlag;
	}

	public void setVirtualFlag(String virtualFlag) {
		this.virtualFlag = virtualFlag;
	}

	public String getInPersonFlag() {
		return inPersonFlag;
	}

	public void setInPersonFlag(String inPersonFlag) {
		this.inPersonFlag = inPersonFlag;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getPmApproval() {
		return pmApproval;
	}

	public void setPmApproval(String pmApproval) {
		this.pmApproval = pmApproval;
	}

	public String getDaApproval() {
		return daApproval;
	}

	public void setDaApproval(String daApproval) {
		this.daApproval = daApproval;
	}

	public String getPracApproval() {
		return pracApproval;
	}

	public void setPracApproval(String pracApproval) {
		this.pracApproval = pracApproval;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getIsCert() {
		return isCert;
	}

	public void setIsCert(String isCert) {
		this.isCert = isCert;
	}
}

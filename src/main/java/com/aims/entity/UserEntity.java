package com.aims.entity;

import java.util.Date;

/**
 * @author Rajesh K
 * 
 */
public class UserEntity {

	private int id;
	private String usn;
	private String password;
	private String usertype;
	private String branch;
	private String graduationType;
	private Date createdDate;
	private Date modifiedDate;
	private Boolean isFirstTimeLogin;
	private String yearOfJoining;
	private String yearOfPassing;
	
	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getUsn() {
		return usn;
	}

	public void setUsn(String usn) {
		this.usn = usn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Boolean getIsFirstTimeLogin() {
		return isFirstTimeLogin;
	}

	public void setIsFirstTimeLogin(Boolean isFirstTimeLogin) {
		this.isFirstTimeLogin = isFirstTimeLogin;
	}
	public String getGraduationType() {
		return graduationType;
	}

	public void setGraduationType(String graduationType) {
		this.graduationType = graduationType;
	}

	public String getYearOfJoining() {
		return yearOfJoining;
	}

	public void setYearOfJoining(String yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}

	public String getYearOfPassing() {
		return yearOfPassing;
	}

	public void setYearOfPassing(String yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}
	

}

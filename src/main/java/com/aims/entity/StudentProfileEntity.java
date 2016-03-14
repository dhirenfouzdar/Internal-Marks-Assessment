package com.aims.entity;

import java.util.Date;

public class StudentProfileEntity {
	private Integer id;
	private String firstName;
	private String lastName;
	private String usn;
	private String emailId;
	private String gender;
	private String mobileNumber;
	private String alternateNumber;
	private String address;
	private Date createdDate;
	private Date modifiedDate;
	private String yearofjoining;
	private String yearofpassing;
	private String percentage;
	private String attendedclass;
	private String totalclass;
	private String subject;
	private String sem;

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAlternateNumber() {
		return alternateNumber;
	}
	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getYearofjoining() {
		return yearofjoining;
	}
	public void setYearofjoining(String yearofjoining) {
		this.yearofjoining = yearofjoining;
	}
	public String getYearofpassing() {
		return yearofpassing;
	}
	public void setYearofpassing(String yearofpassing) {
		this.yearofpassing = yearofpassing;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public String getAttendedclass() {
		return attendedclass;
	}
	public void setAttendedclass(String attendedclass) {
		this.attendedclass = attendedclass;
	}
	public String getTotalclass() {
		return totalclass;
	}
	public void setTotalclass(String totalclass) {
		this.totalclass = totalclass;
	}
	
}

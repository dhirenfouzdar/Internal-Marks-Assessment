package com.aims.entity;

import java.util.Date;

public class IAEntity {
	private Integer id;
	private String usn;
	private String sem;
	private String test1;
	private String test2;
	private String test3;
	private String subject;
	private String yearofpassing;
	private String averageMarks;
	private Date createdDate;
	private Date modifiedDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public String getTest1() {
		return test1;
	}
	public void setTest1(String test1) {
		this.test1 = test1;
	}
	public String getTest2() {
		return test2;
	}
	public void setTest2(String test2) {
		this.test2 = test2;
	}
	public String getTest3() {
		return test3;
	}
	public void setTest3(String test3) {
		this.test3 = test3;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getYearofpassing() {
		return yearofpassing;
	}
	public void setYearofpassing(String yearofpassing) {
		this.yearofpassing = yearofpassing;
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
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
	public String getAverageMarks() {
		return averageMarks;
	}
	public void setAverageMarks(String averageMarks) {
		this.averageMarks = averageMarks;
	}
}

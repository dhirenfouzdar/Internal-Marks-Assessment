package com.aims.action;

import java.util.Date;

import com.aims.constants.AIMSConstant;
import com.aims.entity.StudentProfileEntity;
import com.aims.service.dao.AIMSServiceDao;
import com.aims.service.dao.impl.AIMSServiceDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class StudentProfileAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String firstName;
	private String lastName;
	//private String usn;
	private String emailId;
	private String gender;
	private String mobileNumber;
	private String alternateNumber;
	private String address;
	private Date createdDate;
	private Date modifiedDate;
	private String yearofjoining;
	private String yearofpassing;
	private String oper;
	AIMSServiceDao aIMSService;
	AIMSConstant aIMSConstant;
	SessionAction sessionAction;
	StudentProfileEntity studentProfileEntity = new StudentProfileEntity();
	public StudentProfileAction() {
		aIMSService = new AIMSServiceDaoImpl();
		sessionAction = new SessionAction();

	}
public String addStudentProfile(){
	if (!sessionAction.isValidSession()) {
		return "sessionError";
	}
		if(aIMSService.isMobileNumberExists(getMobileNumber())){
		this.addActionMessage("MobileNumber Already Exists");
		return "error";
		}
	if ( getAlternateNumber() != null && aIMSService.isMobileNumberExists(getAlternateNumber())){
		this.addActionMessage("Alternate MobileNumber Already Exists");
		return "error";
	}
		LOG.info("Logged USN", sessionAction.getUSNBySession());
		studentProfileEntity.setUsn(sessionAction.getUSNBySession());
		studentProfileEntity.setAddress(address);
		studentProfileEntity.setAlternateNumber(alternateNumber);
		studentProfileEntity.setEmailId(emailId);
		studentProfileEntity.setFirstName(firstName);
		studentProfileEntity.setGender(gender);
		studentProfileEntity.setLastName(lastName);
		studentProfileEntity.setMobileNumber(mobileNumber);
		studentProfileEntity.setCreatedDate(new Date());
		studentProfileEntity.setModifiedDate(new Date());
		studentProfileEntity.setYearofjoining(yearofjoining);
		studentProfileEntity.setYearofpassing(yearofpassing);
		aIMSService.addStudentProfile(studentProfileEntity);
		addActionMessage("Profile details added successfully");
		LOG.info("Student Ended adding Profile");
		return "success";
	}
	
public String updateStudentProfile(){
	LOG.info("*************Updating Student profile*********");
	LOG.info("********OPER VALUE****"+oper);
	if (getOper().equalsIgnoreCase(aIMSConstant.GRID_EDIT)) {
			LOG.info("**************Editing Student Profile*********");
			studentProfileEntity.setFirstName(firstName);
			studentProfileEntity.setLastName(lastName);
			studentProfileEntity.setMobileNumber(mobileNumber);
			studentProfileEntity.setAlternateNumber(alternateNumber);
			studentProfileEntity.setGender(gender);
			studentProfileEntity.setModifiedDate(new Date());
			studentProfileEntity.setId(id);
			studentProfileEntity.setAddress(address);
			studentProfileEntity.setEmailId(emailId);
			studentProfileEntity.setYearofpassing(yearofpassing);
			studentProfileEntity.setId(id);
			aIMSService.updateStudentProfile(studentProfileEntity);
			}else if(oper.equalsIgnoreCase(aIMSConstant.GRID_DELETE)){
			aIMSService.deleteStudent(id);
			addActionMessage("Student Details Deleted Successfully.!");
			}
			return "success";

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
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	public AIMSServiceDao getaIMSService() {
		return aIMSService;
	}
	public void setaIMSService(AIMSServiceDao aIMSService) {
		this.aIMSService = aIMSService;
	}
	public StudentProfileEntity getStudentProfileEntity() {
		return studentProfileEntity;
	}
	public void setStudentProfileEntity(StudentProfileEntity studentProfileEntity) {
		this.studentProfileEntity = studentProfileEntity;
	}
	public AIMSConstant getaIMSConstant() {
		return aIMSConstant;
	}
	public void setaIMSConstant(AIMSConstant aIMSConstant) {
		this.aIMSConstant = aIMSConstant;
	}
	public SessionAction getSessionAction() {
		return sessionAction;
	}
	public void setSessionAction(SessionAction sessionAction) {
		this.sessionAction = sessionAction;
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
}

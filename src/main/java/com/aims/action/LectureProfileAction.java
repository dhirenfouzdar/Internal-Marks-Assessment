package com.aims.action;

import java.util.Date;
import java.util.List;

import com.aims.constants.AIMSConstant;
import com.aims.entity.LectureProfileEntity;
import com.aims.service.dao.AIMSServiceDao;
import com.aims.service.dao.impl.AIMSServiceDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class LectureProfileAction extends ActionSupport{
	private Integer id;
	private String firstName;
	private String lastName;
	private String usn;
	private String emailId;
	private String gender;
	private String mobileNumber;
	private String alternateNumber;
	private String designation;
	private Date createdDate;
	private Date modifiedDate;
	private String address;
	private String oper;
	AIMSServiceDao aIMSService;
	AIMSConstant aIMSConstant;
	SessionAction sessionAction;
	LectureProfileEntity lectureProfileEntity = new LectureProfileEntity();

	public LectureProfileAction() {
		sessionAction = new SessionAction();
		aIMSService = new AIMSServiceDaoImpl();
	}
	
	public String addLecturerProfile(){
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
		lectureProfileEntity.setUsn(sessionAction.getUSNBySession());
		lectureProfileEntity.setFirstName(firstName);
		lectureProfileEntity.setLastName(lastName);
		lectureProfileEntity.setMobileNumber(mobileNumber);
		lectureProfileEntity.setAlternateNumber(alternateNumber);
		lectureProfileEntity.setEmailId(emailId);
		lectureProfileEntity.setDesignation(designation);
		lectureProfileEntity.setGender(gender);
		lectureProfileEntity.setAddress(address);
		lectureProfileEntity.setAlternateNumber(alternateNumber);
		lectureProfileEntity.setCreatedDate(new Date());
		lectureProfileEntity.setModifiedDate(new Date());
		aIMSService.addLecturerProfile(lectureProfileEntity);
		addActionMessage("Profile details added successfully");
		return "success";
	}
	

	public String updateLecturerProfile(){
		LOG.info("*************Updating lecturer profile*********");
	
		
		LOG.info("********OPER VALUE****"+oper);
		if (getOper().equalsIgnoreCase(aIMSConstant.GRID_EDIT)) {
				LOG.info("**************Editing Lecturer Profile*********");
				lectureProfileEntity.setFirstName(firstName);
				lectureProfileEntity.setLastName(lastName);
				lectureProfileEntity.setMobileNumber(mobileNumber);
				lectureProfileEntity.setAlternateNumber(alternateNumber);
				lectureProfileEntity.setDesignation(designation);
				lectureProfileEntity.setGender(gender);
				lectureProfileEntity.setAddress(address);
				lectureProfileEntity.setEmailId(emailId);
				lectureProfileEntity.setModifiedDate(new Date());
				lectureProfileEntity.setId(id);
				aIMSService.updateLecturerProfile(lectureProfileEntity);
				addActionMessage("Updated successfully !");
			}else if(oper.equalsIgnoreCase(aIMSConstant.GRID_DELETE)){
				aIMSService.deleteLecture(id);
				addActionMessage("Lecture profile Details Deleted Successfully.!");
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
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public SessionAction getSessionAction() {
		return sessionAction;
	}

	public void setSessionAction(SessionAction sessionAction) {
		this.sessionAction = sessionAction;
	}

	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
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
	public LectureProfileEntity getLectureProfileEntity() {
		return lectureProfileEntity;
	}

	public void setLectureProfileEntity(LectureProfileEntity lectureProfileEntity) {
		this.lectureProfileEntity = lectureProfileEntity;
	}

}

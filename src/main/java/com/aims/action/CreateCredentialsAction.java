package com.aims.action;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.bson.types.ObjectId;

import com.aims.constants.AIMSConstant;
import com.aims.entity.UserEntity;
import com.aims.service.dao.AIMSServiceDao;
import com.aims.service.dao.impl.AIMSServiceDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class CreateCredentialsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usn;
	private String branch;
	private String graduationType;
	private Integer id;
	private String yearOfJoining;
	private String yearOfPassing;
	private Integer strength;
	private String oper;
	AIMSServiceDao aIMSService;
	AIMSConstant aIMSConstant;
	public CreateCredentialsAction(){
		aIMSService = new AIMSServiceDaoImpl();
	}
	
	public String  generateCredentials(){
		/*if(getUsn() != null && aIMSService.isempIDExists(usn)){
			this.addActionMessage("Employee : "+usn+" already exists!");
			return "error";
		}*/
		UserEntity userEntity = new UserEntity();
		userEntity.setUsn(usn);
		userEntity.setBranch(branch);
	    userEntity.setPassword(generatePassword());
		userEntity.setIsFirstTimeLogin(true);
		userEntity.setUsertype(AIMSConstant.LECTURER);
		userEntity.setCreatedDate(new Date());
		userEntity.setModifiedDate(new Date());
		aIMSService.addCredentials(userEntity);
		this.addActionMessage(" Added Succeesfully");
		return "success";
	}
	
	public String updateCredentials(){
			if (oper.equalsIgnoreCase(AIMSConstant.GRID_EDIT)) {
				UserEntity userEntity = new UserEntity();
				userEntity.setId(id);
				userEntity.setUsn(usn);
				//userEntity.setGraduationType(graduationType);
				aIMSService.updateUserdetails(userEntity);
		addActionMessage("User Details Updated Successfully.!");
			}else if(oper.equalsIgnoreCase(aIMSConstant.GRID_DELETE)){
				aIMSService.deleteUser(id);
				addActionMessage("Lecture Details Deleted Successfully.!");
			}
		
			return "success";
		
}
	public AIMSConstant getaIMSConstant() {
		return aIMSConstant;
	}

	public void setaIMSConstant(AIMSConstant aIMSConstant) {
		this.aIMSConstant = aIMSConstant;
	}

	public String addStudentDetails() {
		
		if (aIMSService.isUserExists(getYearOfJoining())) {
			this.addActionMessage("USN list already generated for Branch :: "
					+ branch + " " + "year :: " + yearOfJoining);
			return "error";
		}
		LOG.info("YearOfJoining in validate method :: " + getYearOfJoining());
		List<UserEntity> userList = new LinkedList<UserEntity>();
		Integer classStrength = getStrength();
		LOG.info("strength :: " + getStrength());
		if (getStrength() != null && getStrength() > 0) {
				userList = generatePgUsn(classStrength,
						AIMSConstant.USN_CODE);
		}
		LOG.info("*******Generated Usn Value*****");
		for (UserEntity user1 : userList) {
			System.out.println("Usn:" + user1.getUsn());
		}
		aIMSService.addUser(userList);
		if (userList.size() != 0 && !userList.isEmpty())
			addActionMessage("USN Generated successfully for Branch :: "
					+ getBranch() + " Year :: " + getYearOfJoining());
		LOG.info("Selected drop down value :: " + getBranch());
		LOG.info("selected drop down value :: " + getYearOfJoining());
		LOG.info("selected drop down value :: " + getStrength());
		return SUCCESS;

	}

	public List<UserEntity> generatePgUsn(int strength, String usnChar) {
		List<UserEntity> userList = new LinkedList<UserEntity>();

		System.out.println("UG STRENGTH::" + strength);
		String password;
		String usn = null;
		UserEntity user = null;
		for (int i = 1; i <= strength; i++) {
			if (i <= 9)
				usn = AIMSConstant.COLLEGE_CODE
						+ yearOfJoining.substring(2) + getBranch() + usnChar
						+ i;
			else if (i >= 10 && i <= 99)
				usn = AIMSConstant.COLLEGE_CODE
						+ yearOfJoining.substring(2) + getBranch()
						 + i;
			else
				usn = AIMSConstant.COLLEGE_CODE
						+ yearOfJoining.substring(2) + getBranch() + i;

			password = generatePassword();
			user = new UserEntity();
			user.setUsn(usn);
			user.setPassword(password);
			user.setUsertype(AIMSConstant.STUDENT);
			user.setBranch(getBranch());
			user.setGraduationType("PG");
			user.setIsFirstTimeLogin(true);
			user.setYearOfJoining(getYearOfJoining());
			user.setYearOfPassing(getYearOfPassing());
			user.setCreatedDate(new Date());
			user.setModifiedDate(new Date());
			userList.add(user);

		}
		return userList;
	}
	
		
	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}
	public String getUsn() {
		return usn;
	}

	public void setUsn(String usn) {
		this.usn = usn;
	}

	
	public AIMSServiceDao getaIMSService() {
		return aIMSService;
	}

	public void setaIMSService(AIMSServiceDao aIMSService) {
		this.aIMSService = aIMSService;
	}

	private static String generatePassword() {
		return new ObjectId().toString();
	}

	public String getOper() {
		return oper;
	}

	
	public void setOper(String oper) {
		this.oper = oper;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getGraduationType() {
		return graduationType;
	}

	public void setGraduationType(String graduationType) {
		this.graduationType = graduationType;
	}

	
	public void setYearOfJoining(String yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}

	public void setYearOfPassing(String yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}

	public String getYearOfJoining() {
		return yearOfJoining;
	}

	public String getYearOfPassing() {
		return yearOfPassing;
	}

	
}

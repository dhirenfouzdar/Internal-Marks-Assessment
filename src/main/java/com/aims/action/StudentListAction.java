package com.aims.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.aims.constants.AIMSConstant;
import com.aims.entity.IAEntity;
import com.aims.entity.StudentProfileEntity;
import com.aims.service.dao.AIMSServiceDao;
import com.aims.service.dao.impl.AIMSServiceDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class StudentListAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String yearofPassing;
	private String oper;
	AIMSServiceDao aIMSService;
	AIMSConstant aIMSConstant;
	SessionAction sessionAction;
	private String sem;
	private String subject;
	private String percentage;
	private String attendedclass;
	private String totalclass;
	
	private static Logger LOG = Logger.getLogger(StudentListAction.class);
	List<StudentProfileEntity> studentList = new ArrayList<StudentProfileEntity>();
	List<IAEntity> studentInternalsMarks = new ArrayList<IAEntity>();

	public StudentListAction(){
		sessionAction = new SessionAction();
		aIMSService = new AIMSServiceDaoImpl();
		
	}

	public String getStudentListDetails() {
		if(!sessionAction.isValidSession()){
			return "sessionError";
		}
		LOG.info("***yearofPassing**"+getYearofPassing());
		LOG.info("***sem**"+getSem());
		if(getSem() != null && getSubject() != null){
			aIMSService.updateSemDetails(yearofPassing, sem);
			aIMSService.updateSubjectDetails(yearofPassing, subject);
			studentList = null;
			studentList = aIMSService
					.getStudentList(getYearofPassing());
			if(studentList==null || !(studentList.size() !=0)){
			   this.addActionMessage("No data found !");
			   LOG.info("**Data not found***");
			}
		}
		
		return "success";
	}
	
	public String getStudentMarks() {
		if(!sessionAction.isValidSession()){
			return "sessionError";
		}
		String usn =sessionAction.getUSNBySession();
		// studentInternalsMarks = null;
		studentInternalsMarks = aIMSService.displayStudentDetail(usn, sem, subject);
		if(studentInternalsMarks == null || studentInternalsMarks.size() <=0){
			this.addActionMessage("no records found");
			return "error";
		}
		/*for(IAEntity iaE:studentInternalsMarks){
			LOG.info("USN:::"+iaE.getUsn());
			LOG.info("averageMarks:::"+iaE.getAverageMarks());
		}*/
		return "success";
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

	public SessionAction getSessionAction() {
		return sessionAction;
	}

	public void setSessionAction(SessionAction sessionAction) {
		this.sessionAction = sessionAction;
	}

	public String getYearofPassing() {
		return yearofPassing;
	}

	public void setYearofPassing(String yearofPassing) {
		this.yearofPassing = yearofPassing;
	}

	public AIMSConstant getaIMSConstant() {
		return aIMSConstant;
	}

	public void setaIMSConstant(AIMSConstant aIMSConstant) {
		this.aIMSConstant = aIMSConstant;
	}

	public List<StudentProfileEntity> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<StudentProfileEntity> studentList) {
		this.studentList = studentList;
	}

	public String getSem() {
		return sem;
	}

	public void setSem(String sem) {
		this.sem = sem;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	public List<IAEntity> getStudentInternalsMarks() {
		return studentInternalsMarks;
	}

	public void setStudentInternalsMarks(List<IAEntity> studentInternalsMarks) {
		this.studentInternalsMarks = studentInternalsMarks;
	}

	

}

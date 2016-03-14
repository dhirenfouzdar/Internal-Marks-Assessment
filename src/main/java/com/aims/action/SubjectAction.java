package com.aims.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;

import com.aims.constants.AIMSConstant;
import com.aims.entity.LectureSubjectEntity;
import com.aims.entity.UserEntity;
import com.aims.service.dao.AIMSServiceDao;
import com.aims.service.dao.impl.AIMSServiceDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class SubjectAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<UserEntity> lectureProfileList;
	//private List<String> empId;
	AIMSServiceDao aIMSService;
	private List<String> subject =new ArrayList<String>();
	private String usn;
	private String sem;
	private String oper;
	private Integer id;
	LectureSubjectEntity lectureSubjectEntity = new LectureSubjectEntity();
	List<LectureSubjectEntity> lectureSubjectEntities = new ArrayList<LectureSubjectEntity>();
	SessionAction sessionAction;
	AIMSConstant aIMSConstant;
	public SubjectAction() {
		aIMSService = new AIMSServiceDaoImpl();
		sessionAction=new SessionAction();
	}
	
	public String addLecturerSubject(){
		if (!sessionAction.isValidSession()) {
			return "sessionError";
		}
		LOG.info("Logged USN", sessionAction.getUSNBySession());
		LOG.info("Subject size::"+subject.size());
		if (getSubject() != null && getSubject().size() > 3) {
			addActionMessage("Maximum 3 subject for lecturer");
			return "success";
		}
		if (getSubject() != null && getSubject().size() >= 1) {
			for( String sub:subject)
			{
				lectureSubjectEntity =  new LectureSubjectEntity();
				LOG.info("subject:"+sub);
				lectureSubjectEntity.setUsn(getUsn());
				lectureSubjectEntity.setSem(sem);
				lectureSubjectEntity.setCreatedDate(new Date());
				lectureSubjectEntity.setModifiedDate(new Date());
				lectureSubjectEntity.setSubject(sub);
				aIMSService.addLectureSubject(lectureSubjectEntity);
				lectureProfileList = null;
				lectureProfileList =  aIMSService.getLecturerList();
			}
		}
	//	aIMSService.addLectureSubject(lectureSubjectEntity);
		addActionMessage("Subject details added successfully");
		return "success";
	}
	
	public String deleteLecturerSubject(){
		LOG.info("*************Updating lecturer profile*********");
		if (!sessionAction.isValidSession()) {
			return "sessionError";
		}
		LOG.info("id::"+id);
		LOG.info("********OPER VALUE****"+oper);
		if (oper.equalsIgnoreCase(aIMSConstant.GRID_DELETE)){
				aIMSService.deleteSubject(id);
				addActionMessage("Subject Details Deleted Successfully.!");
			}
		
			return "success";
		
}
	
	public String displaylectureProfile() {
		if (!sessionAction.isValidSession()) {
			return "sessionError";
		}
		LOG.info("****************Lecture Grid Profile*********");
		try {
			SessionAction sessionAction = new SessionAction();
			String usn = sessionAction.getUSNBySession();
			LOG.info("****************Lecturer Grid Profile usn*********"+ usn);
			lectureProfileList = null;
			lectureProfileList =  aIMSService.getLecturerList();

		}

		catch (Throwable e) {
			// System.out.println("Exception"+e);
			LOG.error("Exception occurred while displayProfile{}", e);
			e.printStackTrace();
		}

		return SUCCESS;

	}

	public String displaylectureSubject() {
		if (!sessionAction.isValidSession()) {
			return "sessionError";
		}
		LOG.info("****************Lecture Grid Profile*********");
		try {
			SessionAction sessionAction = new SessionAction();
			String usn = sessionAction.getUSNBySession();
			LOG.info("****************Lecturer Grid Profile usn*********"+ usn);
			lectureSubjectEntities = null;
			lectureSubjectEntities =  aIMSService.getLecturerSubject(sessionAction.getUSNBySession());

		}

		catch (Throwable e) {
			// System.out.println("Exception"+e);
			LOG.error("Exception occurred while displayProfile{}", e);
			e.printStackTrace();
		}

		return SUCCESS;

	}
	public List<UserEntity> getLectureProfileList() {
		return lectureProfileList;
	}

	public void setLectureProfileList(List<UserEntity> lectureProfileList) {
		this.lectureProfileList = lectureProfileList;
	}
	public List<String> getSubject() {
		return subject;
	}
	public void setSubject(List<String> subject) {
		this.subject = subject;
	}
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}

	public String getSem() {
		return sem;
	}

	public void setSem(String sem) {
		this.sem = sem;
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

	public List<LectureSubjectEntity> getLectureSubjectEntities() {
		return lectureSubjectEntities;
	}

	public void setLectureSubjectEntities(
			List<LectureSubjectEntity> lectureSubjectEntities) {
		this.lectureSubjectEntities = lectureSubjectEntities;
	}

}

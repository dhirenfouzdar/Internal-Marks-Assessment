package com.aims.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.aims.constants.AIMSConstant;
import com.aims.entity.IAEntity;
import com.aims.entity.LectureSubjectEntity;
import com.aims.entity.StudentProfileEntity;
import com.aims.service.dao.AIMSServiceDao;
import com.aims.service.dao.impl.AIMSServiceDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class IAAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String sem;
	private String subject;
	private String yearOfPassing;
	private String test1;
	private String test2;
	private String test3;
	private String oper;
	SessionAction sessionAction;
	AIMSServiceDao aIMSService;
	AIMSConstant aIMSConstant;
	List<LectureSubjectEntity> lectureSubjectEntities = new ArrayList<LectureSubjectEntity>();
	List<IAEntity> averageInternalsList = new ArrayList<IAEntity>();
	private static Logger LOG = Logger.getLogger(IAAction.class);

	public IAAction(){
		sessionAction = new SessionAction();
		aIMSService = new AIMSServiceDaoImpl();
	}

	
	public String addStudentSubjectDetails(){
		if (!sessionAction.isValidSession()) {
			return "sessionError";
		}
		boolean isAlreadyExists=true;
		lectureSubjectEntities = null;
		lectureSubjectEntities =  aIMSService.getLecturerSubject(sessionAction.getUSNBySession());
		List<IAEntity> iaEntities = new ArrayList<IAEntity>();
		iaEntities=null;
		iaEntities = aIMSService.getInternalDetails(getYearOfPassing(),getSubject());
		List<StudentProfileEntity> studentList = new ArrayList<StudentProfileEntity>();
		studentList = null;
		studentList = aIMSService.getStudentList(getYearOfPassing());
		if(studentList == null || studentList.size() <=0){
			this.addActionMessage("No students found!");
			return "error";
		}
		  if(iaEntities != null && iaEntities.size() > 0 && iaEntities.size() == studentList.size()){
			  return "success";
		  }else{
			  if(studentList !=null && studentList.size() !=0){
			  for(StudentProfileEntity student:studentList){
				  isAlreadyExists=false;
				  if(iaEntities != null   && iaEntities.size() > 0){
				  for(IAEntity iAEntity:iaEntities){
					  if(iAEntity.getUsn().equals(student.getUsn())){
						  isAlreadyExists=true;
						  break;
					  }
				  }
				  }
				  if(!isAlreadyExists){
					  LectureSubjectEntity lectureSubjectEntity = new LectureSubjectEntity();
						LOG.info("lecturer sem::"+lectureSubjectEntity.getSem());
						LOG.info("Subject::"+getSubject());
						lectureSubjectEntity = aIMSService.getSubjectDetailsByName(subject);
					  IAEntity iaEntity = new IAEntity();
					  iaEntity.setUsn(student.getUsn());
					  iaEntity.setSubject(getSubject());
					  iaEntity.setSem(lectureSubjectEntity.getSem());
					  iaEntity.setYearofpassing(getYearOfPassing());
					  iaEntity.setCreatedDate(new Date());
					  iaEntity.setModifiedDate(new Date());
					  aIMSService.addIAMDetails(iaEntity);
				  }
			  }
			}
		/*if(studentList !=null && studentList.size() !=0){
			LectureSubjectEntity lectureSubjectEntity = new LectureSubjectEntity();
			LOG.info("lecturer sem::"+lectureSubjectEntity.getSem());
			LOG.info("Subject::"+getSubject());
			lectureSubjectEntity = aIMSService.getSubjectDetailsByName(subject);
			for(StudentProfileEntity studentEntity:studentList){
				IAEntity iaEntity = new IAEntity();
				  iaEntity.setUsn(studentEntity.getUsn());
				  iaEntity.setSubject(getSubject());
				  iaEntity.setSem(lectureSubjectEntity.getSem());
				  iaEntity.setYearofpassing(getYearOfPassing());
				  iaEntity.setCreatedDate(new Date());
				  iaEntity.setModifiedDate(new Date());
				  aIMSService.addIAMDetails(iaEntity);
			}
			
		}else{
			this.addActionMessage("No students found!");
			return "error";
		}*/
	 }
		return "success";
	}
	
	public String updateIAMarks(){
		LOG.info("*************Updating Student profile*********");
		LOG.info("********OPER VALUE****"+oper);
		if (getOper().equalsIgnoreCase(aIMSConstant.GRID_EDIT)) {
				LOG.info("**************Editing Student Profile*********");
				IAEntity iaentity = new IAEntity(); 

				iaentity.setTest1(test1);
				iaentity.setTest2(test2);
				iaentity.setTest3(test3);
				iaentity.setId(id);
				aIMSService.updateIAMarks(iaentity);
				}/*else if(oper.equalsIgnoreCase(aIMSConstant.GRID_DELETE)){
				aIMSService.deleteStudent(id);
				addActionMessage("Student Details Deleted Successfully.!");
				}*/
				return "success";

		}
	public String calculateAverage(){
		if (!sessionAction.isValidSession()) {
			return "sessionError";
		}
		List<IAEntity> iaEntities = new ArrayList<IAEntity>();
		iaEntities=null;
		iaEntities = aIMSService.getInternalDetails(getYearOfPassing(),getSubject());
		if(iaEntities == null || iaEntities.size() <=0){
			this.addActionMessage("No records found!");
			return "error";
		}
		aIMSService = new AIMSServiceDaoImpl();
		 for(IAEntity iAEntity:iaEntities){
			   double a[] = new double[3];
			    a[0] = isNumeric(iAEntity.getTest1()) ? Double.parseDouble(iAEntity.getTest1()):0;
			    a[1] = isNumeric(iAEntity.getTest2()) ? Double.parseDouble(iAEntity.getTest2()):0;
			  a[2] = isNumeric(iAEntity.getTest3()) ? Double.parseDouble(iAEntity.getTest3()):0;
			   //int maxNum = getMaxNumber(marks1,marks2,marks3);
			  sortArray(a);
			  for(int i=0;i<a.length;i++){
				  LOG.info("array value::"+a[i]);
			  }
			  double avgMarks = Math.round((a[0]+a[1])/2);
			  LOG.info("Average marks::"+avgMarks);
			   IAEntity iaEntity = new IAEntity();
			   String averageMarks=""+avgMarks;
			   averageMarks = averageMarks.substring(0,2);
			   iaEntity.setId(iAEntity.getId());
			   iaEntity.setAverageMarks(averageMarks);
			   aIMSService.updateAverageMarks(iaEntity);
			   }
		 averageInternalsList = aIMSService.getInternalDetails(getYearOfPassing(),getSubject());
		 this.addActionMessage("Successfully generated average");
		return "success";
	}
	
	private void sortArray(double []a){
		int n=3;
		for (int c = 0; c < ( n - 1 ); c++) {
		      for (int d = 0; d < n - c - 1; d++) {
		        if (a[d] < a[d+1]) /* For descending order use < */
		        {
		          double swap       = a[d];
		          a[d]   = a[d+1];
		          a[d+1] = swap;
		        }
		      }
		    }
	}
	
	/*private int getMaxNumber(int marks1,int marks2,int marks3){
		if(marks1 > marks2 && marks1 > marks3)
		return marks1;
		else if(marks2 > marks3)
			return marks2;
		else 
			return marks3;
	}
	private int secondLargestNumber(int marks1, int marks2){
		if(marks1 > marks2)
			return marks1;
		else return marks2;
	}*/
	private static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}
	public SessionAction getSessionAction() {
		return sessionAction;
	}


	public void setSessionAction(SessionAction sessionAction) {
		this.sessionAction = sessionAction;
	}


	public AIMSServiceDao getaIMSService() {
		return aIMSService;
	}


	public void setaIMSService(AIMSServiceDao aIMSService) {
		this.aIMSService = aIMSService;
	}


	public AIMSConstant getaIMSConstant() {
		return aIMSConstant;
	}


	public void setaIMSConstant(AIMSConstant aIMSConstant) {
		this.aIMSConstant = aIMSConstant;
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
	public String getYearOfPassing() {
		return yearOfPassing;
	}
	public void setYearOfPassing(String yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
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


	public String getOper() {
		return oper;
	}


	public void setOper(String oper) {
		this.oper = oper;
	}


	public List<LectureSubjectEntity> getLectureSubjectEntities() {
		return lectureSubjectEntities;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setLectureSubjectEntities(
			List<LectureSubjectEntity> lectureSubjectEntities) {
		this.lectureSubjectEntities = lectureSubjectEntities;
	}


	public List<IAEntity> getAverageInternalsList() {
		return averageInternalsList;
	}


	public void setAverageInternalsList(List<IAEntity> averageInternalsList) {
		this.averageInternalsList = averageInternalsList;
	}
	
}

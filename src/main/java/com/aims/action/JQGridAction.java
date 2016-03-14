package com.aims.action;

import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;

import com.aims.constants.AIMSConstant;
import com.aims.entity.IAEntity;
import com.aims.entity.LectureProfileEntity;
import com.aims.entity.LectureSubjectEntity;
import com.aims.entity.StudentProfileEntity;
import com.aims.entity.UserEntity;
import com.aims.service.dao.AIMSServiceDao;
import com.aims.service.dao.impl.AIMSServiceDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class JQGridAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer rows;
	private Integer page;
	private String sord;
	private String sidx;
	private String searchField;
	private String searchString;
	private String searchOper;
	private Integer total;
	private Integer records;
	private String year;
	private String yearofPassing;
	private String usn;
	private String branch;
	private String graduationType;
	private String yearOfPassing;
	private String subject;
	AIMSServiceDao aIMSService;
	List<UserEntity> lecturerList = new ArrayList<UserEntity>();
	List<UserEntity> userList;
	List<LectureProfileEntity> lectureProfileList;
	List<StudentProfileEntity> studentProfileList;
	List<StudentProfileEntity> studentsList;
	List<LectureSubjectEntity> subjectList;
	List<IAEntity> iAEntityList;
	SessionAction sessionAction = new SessionAction();
	private static Logger LOG = Logger.getLogger(JQGridAction.class);
	public JQGridAction() {
		aIMSService = new AIMSServiceDaoImpl();
		this.rows = 0;
		this.page = 0;
		this.sord = "asc";
		this.total = 0;
		this.records = 0;
	}

	public String execute() throws Exception {
		return SUCCESS;
	}

	
	public String getLecturerListDetails(){
		LOG.info("****************Getting logs in users list in jqgrid:********");
		try {
			int to = (rows * page);
			int from = to - rows;
			DetachedCriteria criteria = DetachedCriteria
					.forClass(UserEntity.class);
			criteria.setProjection(null);
			criteria.setResultTransformer(Criteria.ROOT_ENTITY);
			lecturerList = aIMSService.getLecturerList();
			//LOG.info("UserEntity size list:::" +userEntityList.size());
			if(lecturerList != null && lecturerList.size() != 0){
			records = lecturerList.size();
			total = (int) Math.ceil((double) records / (double) rows);
			LOG.info("size::" + lecturerList.size());
			}
		} catch (Throwable e) {
			// System.out.println("Runtime Error::");
			LOG.error("Exception occurred while displaying UserDetails JqGrid", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String studentListDisplay() {
		LOG.info("**********Admin Grid Display method executed*************");
		LOG.info("***year of passing****" + getYearOfPassing());
		userList = new ArrayList<UserEntity>();
		userList = null;
		try {
			int to = (rows * page);
			int from = to - rows;
			DetachedCriteria criteria = DetachedCriteria
					.forClass(UserEntity.class);
			criteria.setProjection(null);
			criteria.setResultTransformer(Criteria.ROOT_ENTITY);
			LOG.info("************Grid Parameter executed*********");
			userList = aIMSService.getUsersByYear(getYearOfPassing());
			records = userList.size();
			total = (int) Math.ceil((double) records / (double) rows);
			LOG.info("size::" + userList.size());
					} catch (Throwable e) {
			LOG.error("Exception occurred while displaying JqGrid{}", e);
			e.printStackTrace();
		}

		return SUCCESS;

	}


	
	public String displaylectureProfile() {
		LOG.info("****************Lecture Grid Profile*********");
		try {
			SessionAction sessionAction = new SessionAction();
			String usn = sessionAction.getUSNBySession();
			LOG.info("****************Lecturer Grid Profile usn*********"
					+ usn);
			lectureProfileList = null;
			/*int to = (rows * page);
			int from = to - rows;*/
			DetachedCriteria criteria = DetachedCriteria
					.forClass(UserEntity.class);
			criteria.setProjection(null);
			criteria.setResultTransformer(Criteria.ROOT_ENTITY);
			lectureProfileList = aIMSService.getLProfile(usn);
			if (!lectureProfileList.isEmpty() && lectureProfileList.size() > 0) {
				records = lectureProfileList.size();
				total = (int) Math.ceil((double) records / (double) rows);
			}

		}

		catch (Throwable e) {
			// System.out.println("Exception"+e);
			LOG.error("Exception occurred while displayProfile{}", e);
			e.printStackTrace();
		}

		return SUCCESS;

	}
	
	public String displayStudentProfile() {
		LOG.info("****************Student Grid Profile*********");
		try {
			SessionAction sessionAction = new SessionAction();
			String usn = sessionAction.getUSNBySession();
			LOG.info("****************Lecturer Grid Profile usn*********"
					+ usn);
			lectureProfileList = null;
			/*int to = (rows * page);
			int from = to - rows;*/
			DetachedCriteria criteria = DetachedCriteria
					.forClass(UserEntity.class);
			criteria.setProjection(null);
			criteria.setResultTransformer(Criteria.ROOT_ENTITY);
			studentProfileList = aIMSService.getSProfile(usn);
			if (!studentProfileList.isEmpty() && studentProfileList.size() > 0) {
				records = studentProfileList.size();
				total = (int) Math.ceil((double) records / (double) rows);
			}

		}

		catch (Throwable e) {
			// System.out.println("Exception"+e);
			LOG.error("Exception occurred while displayProfile{}", e);
			e.printStackTrace();
		}

		return SUCCESS;

	}
	
	public String getStudentDetails() {
		LOG.info("****************Lecturer Grid Profile*********");
		studentsList = new ArrayList<StudentProfileEntity>();
		LOG.info("**YearofPassing***"+getYearOfPassing());
		try {
			if(getYearOfPassing() != null){
			SessionAction sessionAction = new SessionAction();
			String usn = sessionAction.getUSNBySession();
			LOG.info("****************Lecturer Grid Profile usn*********"
					+ usn);
			studentsList = null;
			int to = (rows * page);
			int from = to - rows;
			DetachedCriteria criteria = DetachedCriteria
					.forClass(UserEntity.class);
			criteria.setProjection(null);
			criteria.setResultTransformer(Criteria.ROOT_ENTITY);
			studentsList =  aIMSService.getStudentList(getYearOfPassing());
			LOG.info("Getting in to  getStudentDetails**************"+getStudentsList().size());
			if (!studentsList.isEmpty() && studentsList.size() > 0) {
				records = studentsList.size();
				total = (int) Math.ceil((double) records / (double) rows);
			}

		}
		}

		catch (Throwable e) {
			// System.out.println("Exception"+e);
			LOG.error("Exception occurred while displayProfile{}", e);
			e.printStackTrace();
		}

		
		return SUCCESS;

	}
	
	public String displaysubjectList() {
		LOG.info("****************Subject Grid Profile*********");
		try {
			SessionAction sessionAction = new SessionAction();
			String usn = sessionAction.getUSNBySession();
			LOG.info("****************Subject Grid Profile usn*********"
					+ usn);
			subjectList = null;
			/*int to = (rows * page);
			int from = to - rows;*/
			DetachedCriteria criteria = DetachedCriteria
					.forClass(UserEntity.class);
			criteria.setProjection(null);
			criteria.setResultTransformer(Criteria.ROOT_ENTITY);
			subjectList = aIMSService.getSubjectList();
			if (!subjectList.isEmpty() && subjectList.size() > 0) {
				records = subjectList.size();
				total = (int) Math.ceil((double) records / (double) rows);
			}

		}

		catch (Throwable e) {
			// System.out.println("Exception"+e);
			LOG.error("Exception occurred while displayProfile{}", e);
			e.printStackTrace();
		}

		return SUCCESS;

	}
	
	public String getStudentTestDetails(){
		LOG.info("****************Subject Grid Profile*********");
		try {
			if(getYearOfPassing() != null && getSubject() != null){
			SessionAction sessionAction = new SessionAction();
			String usn = sessionAction.getUSNBySession();
			LOG.info("****************Subject in grid*********"+ getSubject());
			LOG.info("****************yearOfPasing in grid*********"+ getYearOfPassing());
			iAEntityList = null;
			/*int to = (rows * page);
			int from = to - rows;*/
			DetachedCriteria criteria = DetachedCriteria
					.forClass(UserEntity.class);
			criteria.setProjection(null);
			criteria.setResultTransformer(Criteria.ROOT_ENTITY);
			iAEntityList = aIMSService.getInternalDetails(getYearOfPassing(), getSubject());
			if (iAEntityList !=null && iAEntityList.size() > 0) {
				records = iAEntityList.size();
				total = (int) Math.ceil((double) records / (double) rows);
			}
		 }
		}
		catch (Throwable e) {
			LOG.error("Exception occurred while displayProfile{}", e);
			e.printStackTrace();
		}

		return SUCCESS;
		
	}
	
	/*public String displayStudentProfile() {
		LOG.info("Geeting into displayStudentProfile grid method");
		String usn= sessionAction.getUSNBySession();
		studentProfileList = null;
			try {
				int to = (rows * page);
				int from = to - rows;
				DetachedCriteria criteria = DetachedCriteria
						.forClass(UserEntity.class);
				criteria.setProjection(null);
				criteria.setResultTransformer(Criteria.ROOT_ENTITY);
				studentProfileList = aIMSService.getStudnetProfile();
				records = studentProfileList.size();
				total = (int) Math.ceil((double) records / (double) rows);
				System.out.println("size::" + studentProfileList.size());
			} catch (Throwable e) {
				// System.out.println("Runtime Error::");
				LOG.error("Exception occurred while displaying JqGrid{}", e);
				e.printStackTrace();
			}

			return SUCCESS;
		}*/
	
	/*	public String displaylectureProfile() {
	LOG.info("Geeting into displaylectureProfile grid method");
	String usn= sessionAction.getUSNBySession();
//	lectureProfileList = null;
		try {
			int to = (rows * page);
			int from = to - rows;
			DetachedCriteria criteria = DetachedCriteria
					.forClass(UserEntity.class);
			criteria.setProjection(null);
			criteria.setResultTransformer(Criteria.ROOT_ENTITY);
			lectureProfileList = aIMSService.getLectureProfile();
			records = lectureProfileList.size();
			total = (int) Math.ceil((double) records / (double) rows);
			System.out.println("size::" + lectureProfileList.size());
		} catch (Throwable e) {
			// System.out.println("Runtime Error::");
			LOG.error("Exception occurred while displaying JqGrid{}", e);
			e.printStackTrace();
		}

		return SUCCESS;
	}*/
	
	public List<StudentProfileEntity> getStudentProfileList() {
		return studentProfileList;
	}

	public void setStudentProfileList(List<StudentProfileEntity> studentProfileList) {
		this.studentProfileList = studentProfileList;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getSearchOper() {
		return searchOper;
	}

	public void setSearchOper(String searchOper) {
		this.searchOper = searchOper;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}


	public String getYearofPassing() {
		return yearofPassing;
	}

	public void setYearofPassing(String yearofPassing) {
		this.yearofPassing = yearofPassing;
	}

	public String getGraduationType() {
		return graduationType;
	}

	public void setGraduationType(String graduationType) {
		this.graduationType = graduationType;
	}

	public List<UserEntity> getUserDetailsList() {
		return lecturerList;
	}

	public List<UserEntity> getLecturerList() {
		return lecturerList;
	}

	public void setLecturerList(List<UserEntity> lecturerList) {
		this.lecturerList = lecturerList;
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

	public List<UserEntity> getUserList() {
		return userList;
	}

	public void setUserList(List<UserEntity> userList) {
		this.userList = userList;
	}

	public List<LectureProfileEntity> getLectureProfileList() {
		return lectureProfileList;
	}

	public void setLectureProfileList(List<LectureProfileEntity> lectureProfileList) {
		this.lectureProfileList = lectureProfileList;
	}

	public List<StudentProfileEntity> getStudentsList() {
		return studentsList;
	}

	public void setStudentsList(List<StudentProfileEntity> studentsList) {
		this.studentsList = studentsList;
	}

	public SessionAction getSessionAction() {
		return sessionAction;
	}

	public void setSessionAction(SessionAction sessionAction) {
		this.sessionAction = sessionAction;
	}

	public List<LectureSubjectEntity> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<LectureSubjectEntity> subjectList) {
		this.subjectList = subjectList;
	}

	public List<IAEntity> getiAEntityList() {
		return iAEntityList;
	}

	public void setiAEntityList(List<IAEntity> iAEntityList) {
		this.iAEntityList = iAEntityList;
	}

	public String getYearOfPassing() {
		return yearOfPassing;
	}

	public void setYearOfPassing(String yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}

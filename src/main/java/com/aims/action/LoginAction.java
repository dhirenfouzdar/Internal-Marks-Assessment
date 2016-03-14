package com.aims.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.aims.constants.AIMSConstant;
import com.aims.entity.LectureSubjectEntity;
import com.aims.service.dao.AIMSServiceDao;
import com.aims.service.dao.impl.AIMSServiceDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private String usn;
	private String password;
	
	private AIMSServiceDao aIMSService;
	
	private static Logger LOG = Logger.getLogger(LoginAction.class);
	HttpServletRequest request = ServletActionContext.getRequest();
	List<LectureSubjectEntity> lectureSubjectEntities = new ArrayList<LectureSubjectEntity>();
	SessionMap<String, String> sessionmap;

	public LoginAction() {
		aIMSService = new AIMSServiceDaoImpl();
	}

	@Override
	public String execute() {
		LOG.info("****Username:****"+usn);
		LOG.info("*****PASSWORD****"+getPassword());

		int userType = 0;
		if (getUsn() != null && getPassword() != null) {
			userType = aIMSService.validateUser(usn.toUpperCase(),password);
		}else{
			return "error";
		}
		if (userType == AIMSConstant.USER_ADMIN) {
			sessionmap.put("login", "true");
			sessionmap.put("usn", usn);
			return "adminsuccess";
		} else if (userType == 2) {
			sessionmap.put("login", "true");
			sessionmap.put("usn", usn);
			return "studentSuccess";
		}else if (userType == 3) {
			sessionmap.put("login", "true");
			sessionmap.put("usn", usn);
			return "firstTimeLoginSuccess";
		} 
		else if (userType == 4) {
			sessionmap.put("login", "true");
			sessionmap.put("usn", usn);
			lectureSubjectEntities = null;
			lectureSubjectEntities =  aIMSService.getLecturerSubject(usn);
			return "lecturerSuccess";
		}  
		else {
			this.addActionMessage("Invalid usn or password");
			return "error";
		}
	}
	public AIMSServiceDao getaIMSService() {
		return aIMSService;
	}

	public void setaIMSService(AIMSServiceDao aIMSService) {
		this.aIMSService = aIMSService;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public SessionMap<String, String> getSessionmap() {
		return sessionmap;
	}

	public void setSessionmap(SessionMap<String, String> sessionmap) {
		this.sessionmap = sessionmap;
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

	@Override
	public void setSession(Map map) {
		sessionmap = (SessionMap) map;
		sessionmap.put("login", "true");
	}

	public List<LectureSubjectEntity> getLectureSubjectEntities() {
		return lectureSubjectEntities;
	}

	public void setLectureSubjectEntities(
			List<LectureSubjectEntity> lectureSubjectEntities) {
		this.lectureSubjectEntities = lectureSubjectEntities;
	}
}

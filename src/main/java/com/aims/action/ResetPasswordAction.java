package com.aims.action;

import com.aims.constants.AIMSConstant;
import com.aims.service.dao.AIMSServiceDao;
import com.aims.service.dao.impl.AIMSServiceDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Svarks
 *
 */
public class ResetPasswordAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String currentPassword;
	private String newPassword;
	AIMSServiceDao aIMSService;
	AIMSConstant aIMSConstant;
	SessionAction sessionAction;
	
	public ResetPasswordAction(){
		aIMSService = new AIMSServiceDaoImpl();
		sessionAction = new SessionAction();
		
		
	}
	
	public String updatenewpassword() {
		if (!sessionAction.isValidSession()) {
			return "sessionError";
		}
		String usnValue= sessionAction.getUSNBySession();
		LOG.info("empId :: " + usnValue);
		LOG.info("Current password::"+currentPassword);
		if (!aIMSService.validatePassword(usnValue, currentPassword)){
			this.addActionMessage("Invalid current password");
			return "error";
		}
		Integer id = aIMSService.FindById(usnValue);
		aIMSService.resetPassword(id, newPassword);
		this.addActionMessage("Password Updated Successfully");
		return "success";
		
	}
	
	public String getCurrentPassword() {
		return currentPassword;
	}
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
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

	public SessionAction getSessionAction() {
		return sessionAction;
	}

	public void setSessionAction(SessionAction sessionAction) {
		this.sessionAction = sessionAction;
	}
	
	

}

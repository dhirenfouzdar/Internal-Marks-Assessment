package com.aims.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.log4j.Logger;

public class LogoutAction extends ActionSupport {

	private static Logger LOG = Logger.getLogger(LogoutAction.class);

	private static final long serialVersionUID = 1L;

	public String execute() {
		Map session = ActionContext.getContext().getSession();
		String login = (String) session.get("login");
		String usn = (String) session.get("usn");
		LOG.info("logout session values::" + login);
		LOG.info("logout session username::" + usn);
		session.remove("login");
		session.remove("empId");
		return SUCCESS;
	}
	/*@SuppressWarnings("rawtypes")
	public void logoutManually(){
		Map session = ActionContext.getContext().getSession();
		String login = (String) session.get("login");
		String empId = (String) session.get("empID");
		LOG.info("logout session values::" + login);
		LOG.info("logout session username::" + empId);
		session.remove("login");
		session.remove("empId");
		
	}*/
	
	
}
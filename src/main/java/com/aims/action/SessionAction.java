package com.aims.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.log4j.Logger;

public class SessionAction {
	private static Logger LOG = Logger.getLogger(SessionAction.class);

	public boolean isValidSession() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("login");
		String usn = (String) session.getAttribute("usn");
		LOG.info("session value :: " + s);
		LOG.info("session usn value :: " + usn);
		if (s != null && usn != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getUSNBySession() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("login");
		String usn = (String) session.getAttribute("usn");
		LOG.info("session value :: " + s);
		LOG.info("session username value :: " + usn);
		if (s != null && usn != null) {
			return usn;
		} else {
			return null;
		}
	}

}

 package com.aims.action;

import com.opensymphony.xwork2.ActionSupport;

public class SessionValidateAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SessionAction sessionAction;
	
	public SessionValidateAction(){
		sessionAction = new SessionAction();
	}
	 
		public String execute() {
			if (!sessionAction.isValidSession()) {
				return "sessionError";
			}
			return SUCCESS;
		}

}

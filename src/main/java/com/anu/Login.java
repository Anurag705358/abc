package com.anu;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email, userpass;
	SessionMap<String, Object> sessionmap;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String execute() {
		
		LoginDao ld = new LoginDao();
		if (ld.validate(this)) {
			sessionmap.put("login", "true");
			sessionmap.put("email", email);
			
			return SUCCESS;
		} else {
			return ERROR;
		}

	}

	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sessionmap = (SessionMap<String, Object>) map;
		

	}

	public String logout() {
		if (sessionmap.size()==0) {
			return ERROR;
		}

		else {
			
			sessionmap.invalidate();
			return SUCCESS;

		}

	}
}

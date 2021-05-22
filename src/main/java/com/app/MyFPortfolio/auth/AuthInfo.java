package com.app.MyFPortfolio.auth;

public class AuthInfo {
	private final String user_id;
	private final String user_pwd;
	private final String user_email;
	private final String user_phone;
	private final String login_type;
	
	
	public AuthInfo(String user_id, String user_pwd, String user_email, String user_phone, String user_login_type) {
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.user_email = user_email;
		this.user_phone = user_phone;
		this.login_type = user_login_type;
		
	}
	
	public String getUserID() {
		return this.user_id;
	}
	
	public String getUserPwd() {
		return this.user_pwd;
	}

	public String getUserEmail() {
		return user_email;
	}

	public String getUserPhone() {
		return user_phone;
	}

	public String getLoginType() {
		return login_type;
	}
}

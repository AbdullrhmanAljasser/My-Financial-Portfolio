package com.app.MyFPortfolio.auth;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthInfo {
	private final String user_id;
	private final String user_pwd;
	private final String user_email;
	private final String user_phone;
	private final String user_login_type;

	@JsonCreator
	public AuthInfo(@JsonProperty("user_id") String user_id, @JsonProperty("user_pwd") String user_pwd,
			@JsonProperty("user_email") String user_email, @JsonProperty("user_phone") String user_phone,
			@JsonProperty("user_login_type") String user_login_type) {
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.user_email = user_email;
		this.user_phone = user_phone;
		this.user_login_type = user_login_type;

	}

	public AuthInfo(String otp_log, String user_login_type) {
		this.user_id = otp_log;
		this.user_pwd = "";
		this.user_email = "";
		this.user_phone = "";
		this.user_login_type = user_login_type;
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
		return user_login_type;
	}
}

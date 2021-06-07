package com.app.MyFPortfolio.MongoCURD;

import org.springframework.data.annotation.Id;

public class PortalProfile {
	@Id
	public String id;
	public String user_id;
	public String user_pwd;
	public String user_phone;
	public String user_email;
	// public String user_dob;
	// public String user_preference; // Loging Preference
	
	public PortalProfile() {}
	
	public PortalProfile(String user_id, String user_pwd, String user_phone, 
			String user_email/*, String user_dob, String user_preference*/) {
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.user_phone = user_phone;
		this.user_email = user_email;
		// this.user_dob = user_dob;
		// this.user_preference = user_preference;
	}
	
	@Override
	public String toString() {
		return String.format(
				"PortalProfile[id=%s, user_id=%s, user_phone=%s, user_email=%s", 
				this.id, this.user_id, this.user_phone, this.user_email);
	}
}

package com.app.MyFPortfolio.auth;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	
	@PostMapping("/register")
	public boolean register(@RequestBody(required=true) AuthInfo user_model, HttpServletResponse response) {
		// TODO: provided a multi-method of registering (OTP)
		if (user_model.getLoginType().toLowerCase().compareTo("id") == 0) {
			// TODO: Make sure password is hashed, then create user object
			response.setStatus(HttpServletResponse.SC_CREATED);
			return true;
		} else if (user_model.getLoginType().toLowerCase().compareTo("phone") == 0) {
			// TODO: Use OTP then create user object
			response.setStatus(HttpServletResponse.SC_CREATED);
			return true;
		} else if (user_model.getLoginType().toLowerCase().compareTo("email") == 0) {
			// TODO: Use OTP then create user object
			response.setStatus(HttpServletResponse.SC_CREATED);
			return true;
		} else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return false;
		}
	}
}

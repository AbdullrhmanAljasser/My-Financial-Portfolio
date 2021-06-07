package com.app.MyFPortfolio.auth;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.mbeans.UserMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.MyFPortfolio.MongoCURD.PortalProfileRepository;
import com.app.MyFPortfolio.MongoCURD.PortalProfile;
import com.app.MyFPortfolio.MongoCURD.PortalProfileRepository;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping(path = "/api")
public class AuthController {
	ConcurrentMap<String, AuthInfo> registered = new ConcurrentHashMap<>();
	ConcurrentMap<String, AuthToken> active_tokens = new ConcurrentHashMap<>();
	// ConcurrentMap<String, FProfile[]> profiles = new ConcurrentHashMap<>();

	@Autowired
	private PortalProfileRepository repository;

	@PostMapping("portal/register")
	public boolean register(@RequestBody(required = true) AuthInfo user_model, HttpServletResponse response) {
		// TODO: provided a multi-method of registering (OTP)
		if (user_model.getLoginType().toLowerCase().compareTo("id") == 0) {
			// TODO: Make sure password is hashed, then create user object
			if (registered.containsKey(user_model.getUserID().toLowerCase())) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				return false;
			}
			
			repository.save(new PortalProfile(user_model.getUserID(), user_model.getUserPwd(), user_model.getUserPhone(), user_model.getUserEmail()));

			response.setStatus(HttpServletResponse.SC_CREATED);
			return true;
		} else if (user_model.getLoginType().toLowerCase().compareTo("phone") == 0) {
			// TODO: Use OTP then create user object
			response.setStatus(HttpServletResponse.SC_CREATED);
			if (registered.containsKey(user_model.getUserPhone().toLowerCase())) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				return false;
			}
			registered.put(user_model.getUserPhone().toLowerCase(),
					new AuthInfo(user_model.getUserPhone().toLowerCase(), "phone"));
			return true;
		} else if (user_model.getLoginType().toLowerCase().compareTo("email") == 0) {
			// TODO: Use OTP then create user object
			response.setStatus(HttpServletResponse.SC_CREATED);
			if (registered.containsKey(user_model.getUserEmail().toLowerCase())) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				return false;
			}

			registered.put(user_model.getUserEmail().toLowerCase(),
					new AuthInfo(user_model.getUserEmail().toLowerCase(), "email"));
			return true;
		} else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return false;
		}
	}

	@PostMapping("portal/login")
	public String login(@RequestBody(required = true) AuthLogin authlogin,  HttpServletResponse response) {
		if (!registered.containsKey(authlogin.getUserID().toLowerCase())) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "Unregistered ID";
		}

		AuthInfo account = registered.get(authlogin.getUserID().toLowerCase());
		
		if (!(account.getUserPwd().compareTo(authlogin.getUserPwd())==0)){
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "Incorrect password";
		}

		active_tokens.put(authlogin.getUserID().toLowerCase(), new AuthToken(authlogin.getUserPwd()));

		return "Token generate it, request to portal/verify with username as verify";
	}

	@GetMapping("portal/verify")
	public AuthToken token(HttpServletResponse response, @RequestHeader(name = "Authorization") String auth) {
		if(!active_tokens.containsKey(auth)){
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}


		return new AuthToken("token");
	}

	@GetMapping("portal/test/registered")
	public Collection<AuthInfo> getAllLoginInfo() {
		return registered.values();
	}

}

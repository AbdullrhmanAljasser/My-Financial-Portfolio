package com.app.MyFPortfolio.MongoCURD;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PortalProfileRepository extends MongoRepository<PortalProfile, String> {
	public PortalProfile findByuser_id(final String user_id);
	// public PortalProfile findByuser_email(final String user_email);
	// public PortalProfile findByuser_phone(final String user_phone);
}

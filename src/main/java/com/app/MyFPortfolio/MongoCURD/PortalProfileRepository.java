package com.app.MyFPortfolio.MongoCURD;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PortalProfileRepository extends MongoRepository<PortalProfile, String> {
//	public PortalProfile findByUser_id(String id);
//	public PortalProfile findByUser_email(String email);
//	public PortalProfile findByUser_phone(String phone);
}
